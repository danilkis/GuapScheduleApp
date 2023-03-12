package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Aud")
data class modelAud(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "aud_id")
    var aud_id: Int,

    @ColumnInfo(name = "name_aud")
    var name_aud: String
)