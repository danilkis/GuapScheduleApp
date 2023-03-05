package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sat")
data class SatModel(
    @PrimaryKey(autoGenerate = true)
    public var idSatKey: Int? = null,

    @ColumnInfo(name = "Sat")
    public var Sat: String,

    @ColumnInfo(name = "SatAudience")
    public var SatAudience: Int,

    @ColumnInfo(name = "SatTeacher")
    public var SatTeacher: Int,
)
