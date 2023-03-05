package com.example.guap31.adapter.SH_day_adapter

import com.example.guap31.adapter.SH_lesson_adapter.Lesson_info

data class day_info(
    val name:String,
    val listLesson: ArrayList<Lesson_info>
)
