package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Thu")
data class ThuModel(
    @PrimaryKey(autoGenerate = true)
    public var idThuKey: Int? = null,

    @ColumnInfo(name = "Thu")
    public var Thu: String,

    @ColumnInfo(name = "ThuAudience")
    public var ThuAudience: Int,

    @ColumnInfo(name = "ThuTeacher")
    public var ThuTeacher: Int,
)
