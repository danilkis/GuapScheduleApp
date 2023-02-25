package com.example.guap31

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.guap31.SH_day_adapter.SH_day_adapter
import com.example.guap31.SH_day_adapter.day_info
import com.example.guap31.SH_lesson_adapter.Lesson_info
import com.example.guap31.databinding.ActivityMainBinding
import org.json.JSONObject



class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var groupLink: MutableMap<String, String>
    private lateinit var DayList: ArrayList<day_info>
    private lateinit var lessonTime: JSONObject

    private lateinit var adapter: SH_day_adapter
    private lateinit var recyclerView: RecyclerView

    private val myLog = "myLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        Log.d(myLog, "|||||||||||||||||||||||||||||||||||||||||||\nonCreate\n-------------------------------------")

        groupLink = getLinkGroup()
        lessonTime = getShJson("time")

        init_spinner_group()
        init_spinner_Week()

        Log.d(myLog, "spinner: ${mainBinding.spinner.selectedItem}\n-")
        Log.d(myLog, "spinner2: ${mainBinding.spinner2.selectedItem}\n" +
                               "--------------------------")

        init_day_list()
    }


    fun init_day_list() {
        Log.d(myLog, "init_day_list\n" +
                "-")
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
        for (i in nameDayList.keys) {
            val LessonList = ArrayList<Lesson_info>()

            val lessons = getShLesson(
                outputJsDateString, groupLink[mainBinding.spinner.selectedItem].toString(),
                nameWeekList[mainBinding.spinner2.selectedItem].toString(), i)



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
        Log.d(myLog, "end init_day_list\n" +
                "--------------------------")
    }

    fun init_spinner_Week() {
        Log.d(myLog, "init_spinner_Week\n" +
                "-")
        val numWeek =
            listOf("Числитель", "Знаменатель" , "Сегодня")
        val list = ArrayAdapter(this, android.R.layout.simple_spinner_item, numWeek)
        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        mainBinding.spinner2.adapter = list
        mainBinding.spinner2.prompt = "Выбери ниделю"

        mainBinding.spinner2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                Log.d(myLog, "onItemSelected\n" +
                        "-")
                init_day_list()
            }

            override fun onNothingSelected(parent: AdapterView<*>) { }
        }
        Log.d(myLog, "end init_spinner_Week\n" +
                "--------------------------")
    }

    fun init_spinner_group() {
        Log.d(myLog, "init_spinner_group\n" +
                "-")
        val list = ArrayAdapter(this, android.R.layout.simple_spinner_item, groupLink.keys.toList())
        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        mainBinding.spinner.adapter = list
        mainBinding.spinner.prompt = "Выбери номер группы"

        mainBinding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                init_day_list()
            }

            override fun onNothingSelected(parent: AdapterView<*>) { }
        }
        Log.d(myLog, "end init_spinner_group\n" +
                "--------------------------")
    }

    fun getLinkGroup(): MutableMap<String, String> {
        val LinkGroup = getShJson("linkage_grop")
        val LinkGroupSet = mutableMapOf<String, String>()

        for (i in LinkGroup.keys())
            LinkGroupSet.put(i, LinkGroup[i].toString())

        return LinkGroupSet
    }

    fun getShLesson(JObject: JSONObject, numGroup: String, numWeek: String, nameDay: String): JSONObject{
        return (JObject
                .getJSONObject(numGroup)
                    .getJSONObject(numWeek)
                        .getJSONObject(nameDay))

    }

    @SuppressLint("DiscouragedApi")
    fun getShJson(nameJsonFile: String): JSONObject{
        val jsDate = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "" + nameJsonFile,
                "raw", applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }

        return JSONObject(jsDate)
    }

}