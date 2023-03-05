package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.guap31.ShDateBase.tabelNameMain

@Entity(tableName = "SH")
data class modelSH(
    @PrimaryKey(autoGenerate = true)
    public var id: Int? = null,

    @ColumnInfo(name = "numLesson")
    public var numLesson: Int,

    @ColumnInfo(name = "Lesson")
    public var Lesson: String? = null
)
