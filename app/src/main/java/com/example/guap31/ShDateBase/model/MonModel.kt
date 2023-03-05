package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Mon")
data class MonModel(
    @PrimaryKey(autoGenerate = true)
    public var idMonKey: Int? = null,

    @ColumnInfo(name = "Mon")
    public var Mon: String,

    @ColumnInfo(name = "MonAudience")
    public var MonAudience: Int,

    @ColumnInfo(name = "MonTeacher")
    public var MonTeacher: Int
)
