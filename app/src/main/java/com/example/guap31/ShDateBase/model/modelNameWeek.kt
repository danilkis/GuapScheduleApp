package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NameWeek")
data class modelNameWeek(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "name_week_id")
    var name_week_id: Int,

    @ColumnInfo(name = "name_week")
    var name_week: String
)
