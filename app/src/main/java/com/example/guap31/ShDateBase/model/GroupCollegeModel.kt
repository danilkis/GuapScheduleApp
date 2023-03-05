package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GroupCollege")
data class GroupCollegeModel(
    @PrimaryKey(autoGenerate = true)
    public var idGroup: Int? = null,

    @ColumnInfo(name = "Number")
    public var Number: String
)


