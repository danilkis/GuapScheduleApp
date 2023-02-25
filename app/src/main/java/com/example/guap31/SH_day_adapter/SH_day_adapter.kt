package com.example.guap31.SH_day_adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.guap31.R
import com.example.guap31.SH_lesson_adapter.Lesson_info
import com.example.guap31.SH_lesson_adapter.SH_lesson_adapter
import com.example.guap31.databinding.DayShLayoutBinding

import kotlinx.android.synthetic.main.day_sh_layout.view.*


class SH_day_adapter: RecyclerView.Adapter<SH_day_adapter.ScheduleHolder>() {
    private lateinit var binding: DayShLayoutBinding

    private var day_info_list = emptyList<day_info>()

    private lateinit var adapter: SH_lesson_adapter
    private lateinit var recyclerView: RecyclerView

    class ScheduleHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.day_sh_layout, parent, false)
        return ScheduleHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {


        holder.itemView.nameDay.text = day_info_list[position].name

        recyclerView = holder.itemView.RViewlesson
        adapter = SH_lesson_adapter()
        recyclerView.adapter = adapter

        adapter.setScheduleList(day_info_list[position].listLesson)

    }

    override fun getItemCount(): Int { return day_info_list.size }

    @SuppressLint("NotifyDataSetChanged")
    fun setScheduleList(ScheduleList: List<day_info>){
        Log.d("myLog", "setScheduleList: ${ScheduleList}")
        day_info_list = ScheduleList
        Log.d("myLog", "day_info_list = ScheduleList")
        notifyDataSetChanged()
        Log.d("myLog", "notifyDataSetChanged")
    }
}