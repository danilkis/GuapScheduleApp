package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tue")
data class TueModel(
    @PrimaryKey(autoGenerate = true)
    public var idTueKey: Int? = null,

    @ColumnInfo(name = "Tue")
    public var Tue: String,

    @ColumnInfo(name = "TueAudience")
    public var TueAudience: Int,

    @ColumnInfo(name = "TueTeacher")
    public var TueTeacher: Int,
)
