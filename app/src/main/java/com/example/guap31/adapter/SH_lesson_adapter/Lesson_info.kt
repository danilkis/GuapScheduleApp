package com.example.guap31.adapter.SH_lesson_adapter

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Lesson_info(

    @ColumnInfo(name = "beginTime")
    val beginTime: String,
    @ColumnInfo(name = "endTime")
    val endTime: String,

    @ColumnInfo(name = "NumLesson")
    val NumLesson: Int,
    @ColumnInfo(name = "NameLesson")
    val NameLesson: String,

    @ColumnInfo(name = "NameTeacher")
    val NameTeacher: String,
    @ColumnInfo(name = "NumAudience")
    val NumAudience: String
    )
