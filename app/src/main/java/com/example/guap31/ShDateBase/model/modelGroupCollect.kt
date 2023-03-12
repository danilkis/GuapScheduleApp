package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GroupCollect")
data class modelGroupCollect(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "group_id")
    var group_id: Int,

    @ColumnInfo(name = "num_group")
    var num_group: String,

)
