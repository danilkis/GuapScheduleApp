package com.example.guap31.adapter.SH_lesson_adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.guap31.R
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.day_sh_layout.view.*
import kotlinx.android.synthetic.main.lesson_sh_layout.view.*


class SH_lesson_adapter: RecyclerView.Adapter<SH_lesson_adapter.ScheduleHolder>() {
    private var lesson_info_list = emptyList<Lesson_info>()

    class ScheduleHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lesson_sh_layout, parent, false)
        return ScheduleHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        // Подготовка и сокрощение доступа к обыектам
        val itemView = holder.itemView

        val numLesson = itemView.numLesson
        val namelesson = itemView.namelesson
        val beginTime = itemView.beginTime
        val endTime = itemView.endTime
        val NameTeacherOne = itemView.NameTeacherOne
        val NumAudienceOne = itemView.NumAudienceOne
        val NameTeacherTwo = itemView.NameTeacherTwo
        val NumAudienceTwo = itemView.NumAudienceTwo

        // Дата класс, расписание группы
        val lesson = lesson_info_list[position]

        // Заполнение Полей данными
        numLesson.text = lesson.NumLesson.toString()
        namelesson.text = lesson.NameLesson

        beginTime.text = lesson.beginTime
        endTime.text = lesson.endTime

        ChipFilling(NameTeacherOne, NameTeacherTwo, lesson.NameTeacher)
        ChipFilling(NumAudienceOne, NumAudienceTwo, lesson.NumAudience)

    }

    // Работа с чип групп для Учителей и Аудиторий
    private fun ChipFilling(oneChip: Chip, twoChip: Chip, date: String){
        val item = date.split("\n")
        oneChip.text = item[0]

        if (item.size == 2){
            twoChip.visibility = View.VISIBLE
            twoChip.text = item[1]
        }
    }


    override fun getItemCount(): Int { return lesson_info_list.size }

    @SuppressLint("NotifyDataSetChanged")
    fun setScheduleList(ScheduleList: List<Lesson_info>){
        lesson_info_list = ScheduleList
        notifyDataSetChanged()
    }
}