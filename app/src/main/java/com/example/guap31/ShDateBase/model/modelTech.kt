package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tech")
data class modelTech(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "tech_id")
    var tech_id: Int,

    @ColumnInfo(name = "name_tech")
    var name_tech: String
)