package com.example.guap31.adapter.SH_lesson_adapter

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Lesson_info(
    @ColumnInfo(name = "name_day")
    val day: String,

    @ColumnInfo(name = "time_begin")
    val beginTime: String,
    @ColumnInfo(name = "time_end")
    val endTime: String,

    @ColumnInfo(name = "num_lesson")
    val NumLesson: Int,
    @ColumnInfo(name = "lesson")
    val NameLesson: String,

    @ColumnInfo(name = "name_tech")
    val NameTeacher: String,
    @ColumnInfo(name = "name_aud")
    val NumAudience: String
    )
