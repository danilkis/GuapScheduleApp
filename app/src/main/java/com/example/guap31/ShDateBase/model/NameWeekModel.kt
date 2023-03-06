package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NameWeek")
data class NameWeekModel(
    @PrimaryKey(autoGenerate = true)
    public var idWeek: Int? = null,

    @ColumnInfo(name = "weekName")
    public var weekName: String,
)