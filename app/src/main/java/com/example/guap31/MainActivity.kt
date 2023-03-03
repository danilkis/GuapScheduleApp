package com.example.guap31

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.guap31.SH_day_adapter.SH_day_adapter
import com.example.guap31.SH_day_adapter.day_info
import com.example.guap31.SH_lesson_adapter.Lesson_info
import com.example.guap31.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButtonToggleGroup
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var groupLink: MutableMap<String, String>
    private lateinit var lessonTime: JSONObject

    private lateinit var DayList: ArrayList<day_info>

    // Для recyclerView
    private lateinit var adapter: SH_day_adapter
    private lateinit var recyclerView: RecyclerView
    /*------------------------------------------------------------*/

    // Спинер меню с Выбором групп
    private lateinit var autoComplecteGroup: AutoCompleteTextView
    private lateinit var adapterGroup: ArrayAdapter<String>
    /*------------------------------------------------------------*/

    // Параметры для формирования recyclerView с расписанием
    private var groupItem: String = "0" // Номер групп
    private var weekItem: String = "1" // Тип нидели(Числитель || Знаменатель)
    /*------------------------------------------------------------*/

    // Подключение Binding ActivityMain
    private lateinit var mainBinding: ActivityMainBinding
    /*------------------------------------------------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        cinnectAllJsonFile()

        init_AutoCompleteTextGroup(ArrayList<String>(groupLink.keys))
        init_toggleButtonWeek()

        init_day_list()
    }

    // Инцелизация toggleButtonWeek menu для нидели
    private fun init_toggleButtonWeek() {
        mainBinding.toggleButtonWeek.addOnButtonCheckedListener(
            MaterialButtonToggleGroup.OnButtonCheckedListener { group, checkedId, isChecked ->
                if (isChecked) {
                    weekItem = when (checkedId) {
                        mainBinding.buttonDenominator.id -> "1"
                        mainBinding.buttonToday.id -> "1"
                        mainBinding.buttonNumerator.id -> "2"
                        else -> "2"
                    }

                    init_day_list()
                }
            })
    }

    // Сборка подключение всех JSON Файлов
    private fun cinnectAllJsonFile(){
        groupLink = getLinkGroup("linkage_grop")
        lessonTime = getShJson("time")
    }

    // Инцелизация Spiner menu для групп
    private fun init_AutoCompleteTextGroup(list: ArrayList<String>){
        autoComplecteGroup = findViewById(R.id.auto_complecte_txt)

        adapterGroup = ArrayAdapter(this, R.layout.list_item, list)
        autoComplecteGroup.setAdapter(adapterGroup)

        autoComplecteGroup.setOnItemClickListener { parent, view, position, id ->
            groupItem = groupLink[parent.getItemAtPosition(position)].toString()
            init_day_list()
        }
    }

    private fun init_day_list() {
        recyclerView = mainBinding.RViewDay
        adapter = SH_day_adapter()
        recyclerView.adapter = adapter


        val nameDayList = mapOf(
            "Пн" to "Понидельник", "Вт" to "Вторник", "Ср" to "Среда",
            "Чт" to "Четверг", "Пт" to "Пятница", "Сб" to "Суббота")

        val nameWeekList = mapOf(
            "Числитель" to "1", "Знаменатель" to "2", "Сегодня" to "1")

        DayList = ArrayList()

        val outputJsDateString = getShJson("date")
        recyclerView.scheduleLayoutAnimation()
        for (i in nameDayList.keys) {
            val LessonList = ArrayList<Lesson_info>()
            val lessons = getShLesson(outputJsDateString, groupItem, weekItem, i)

            lessons.keys().forEach { keyLes ->
                if (lessons[keyLes].toString() != "")
                    LessonList.add(
                        Lesson_info(
                            keyLes,
                            lessons[keyLes].toString(),
                            lessonTime.getJSONObject("begin").getString(keyLes).toString(),
                            lessonTime.getJSONObject("end").getString(keyLes).toString()))
            }

            DayList.add(day_info(nameDayList[i].toString(), LessonList))
        }

        adapter.setScheduleList(DayList)
    }
    private fun getLinkGroup(nameJsonFile: String): MutableMap<String, String> {
        val LinkGroup = getShJson(nameJsonFile)
        val LinkGroupSet = mutableMapOf<String, String>()

        for (i in LinkGroup.keys())
            LinkGroupSet.put(i, LinkGroup[i].toString())

        return LinkGroupSet
    }

    private fun getShLesson(JObject: JSONObject, numGroup: String, numWeek: String, nameDay: String): JSONObject{
        return (JObject
                .getJSONObject(numGroup)
                    .getJSONObject(numWeek)
                        .getJSONObject(nameDay))

    }

    @SuppressLint("DiscouragedApi")
    private fun getShJson(nameJsonFile: String): JSONObject{
        val jsDate = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "" + nameJsonFile,
                "raw", applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }

        return JSONObject(jsDate)
    }

}