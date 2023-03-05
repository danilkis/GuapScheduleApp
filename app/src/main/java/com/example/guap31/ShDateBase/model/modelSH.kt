package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.guap31.ShDateBase.tabelNameMain

@Entity(tableName = "Schedule")
data class modelSH(
    @PrimaryKey(autoGenerate = true)
    public var Id: Int? = null,

    @ColumnInfo(name = "GroupId")
    public var GroupId: Int,

    @ColumnInfo(name = "NumLesson")
    public var NumLesson: Int,

    @ColumnInfo(name = "WeekId")
    public var WeekId: Int,

    @ColumnInfo(name = "Mon")
    public var Mon: Int,

    @ColumnInfo(name = "Tue")
    public var Tue: Int,

    @ColumnInfo(name = "Wed")
    public var Wed: Int,

    @ColumnInfo(name = "Thu")
    public var Thu: Int,

    @ColumnInfo(name = "Fri")
    public var Fri: Int,

    @ColumnInfo(name = "Sat")
    public var Sat: Int

)

