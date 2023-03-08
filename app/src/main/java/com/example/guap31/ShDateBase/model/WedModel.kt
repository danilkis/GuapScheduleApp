package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "TabWed")
data class WedModel(
    @PrimaryKey(autoGenerate = true)
    public var idWedKey: Int? = null,

    @ColumnInfo(name = "Wed")
    public var Wed: String,

    @ColumnInfo(name = "WedAudience")
    public var WedAudience: Int,

    @ColumnInfo(name = "WedTeacher")
    public var WedTeacher: Int,
)
