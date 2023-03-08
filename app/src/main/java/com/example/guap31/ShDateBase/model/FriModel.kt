package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TabFri")
data class FriModel(
    @PrimaryKey(autoGenerate = true)
    public var idFriKey: Int? = null,

    @ColumnInfo(name = "Fri")
    public var Fri: String,

    @ColumnInfo(name = "FriAudience")
    public var FriAudience: Int,

    @ColumnInfo(name = "FriTeacher")
    public var FriTeacher: Int,
)
