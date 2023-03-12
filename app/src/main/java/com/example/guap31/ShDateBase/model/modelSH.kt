package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SH")
data class modelSH(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id")
    var _id: Int? = null,

    @ColumnInfo(name = "id_group")
    var id_group: Int,

    @ColumnInfo(name = "id_name_week")
    var id_name_week: Int,

    @ColumnInfo(name = "name_day")
    var name_day: String,

    @ColumnInfo(name = "num_lesson")
    var num_lesson: Int,

    @ColumnInfo(name = "lesson")
    var lesson: String,

    @ColumnInfo(name = "id_tech")
    var id_tech: Int,

    @ColumnInfo(name = "id_aud")
    var id_aud: Int
)
