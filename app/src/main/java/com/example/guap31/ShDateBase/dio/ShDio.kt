package com.example.guap31.ShDateBase.dio

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.guap31.ShDateBase.model.modelSH
import kotlinx.coroutines.flow.Flow


@Dao
interface ShDio{
    @Insert
    public fun insertDB(item:modelSH)

    @Query("SELECT * FROM SH")
    public fun getAllItem(): Flow<List<modelSH>>
}