package com.example.guap31.ShDateBase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Audience")
data class AudienceModel(
    @PrimaryKey(autoGenerate = true)
    public var idAudience: Int? = null,

    @ColumnInfo(name = "NumAudience")
    public var NumAudience: String,
)
