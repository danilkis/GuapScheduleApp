package com.example.guap31.adapter.SH_lesson_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.guap31.R
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
        holder.itemView.numLesson.text = lesson_info_list[position].NumLesson.toString()
        holder.itemView.namelesson.text = lesson_info_list[position].NameLesson

        holder.itemView.beginTime.text = lesson_info_list[position].beginTime
        holder.itemView.endTime.text = lesson_info_list[position].endTime

        holder.itemView.NameTeacher.text = lesson_info_list[position].NameTeacher
        holder.itemView.NumAudience.text = lesson_info_list[position].NumAudience

    }

    override fun getItemCount(): Int { return lesson_info_list.size }

    @SuppressLint("NotifyDataSetChanged")
    fun setScheduleList(ScheduleList: List<Lesson_info>){
        lesson_info_list = ScheduleList
        notifyDataSetChanged()
    }
}