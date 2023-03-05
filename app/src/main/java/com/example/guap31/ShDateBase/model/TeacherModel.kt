package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Teacher")
data class TeacherModel(
    @PrimaryKey(autoGenerate = true)
    public var idTeacher: Int? = null,

    @ColumnInfo(name = "NameTeacher")
    public var NameTeacher: String,
)
