package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Time")
data class TimeModel(
    @PrimaryKey(autoGenerate = true)
    public var idlesson: Int? = null,

    @ColumnInfo(name = "time_begin")
    public var time_begin: String,

    @ColumnInfo(name = "time_end")
    public var time_end: String

)
