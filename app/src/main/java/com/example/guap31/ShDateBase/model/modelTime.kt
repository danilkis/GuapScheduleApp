package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Time")
data class modelTime(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "time_id")
    var time_id: Int,

    @ColumnInfo(name = "time_begin")
    var time_begin: String,

    @ColumnInfo(name = "time_end")
    var time_end: String
)
