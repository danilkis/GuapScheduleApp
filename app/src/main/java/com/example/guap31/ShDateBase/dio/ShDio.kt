package com.example.guap31.ShDateBase.dio

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.guap31.ShDateBase.model.*
import com.example.guap31.adapter.SH_lesson_adapter.Lesson_info
import kotlinx.coroutines.flow.Flow


@Dao
interface ShDio {
//    @Insert
//    public fun insertDB(item: modelSH)
//
//    @Query("SELECT * FROM Schedule")
//    public fun getAllItem(): Flow<List<modelSH>>

    @Insert(entity = modelSH::class)
    public fun SetItemSH(item: modelSH)

    @Insert(entity = modelGroupCollect::class)
    public fun SetItemGroupCollect(item: modelGroupCollect)

    @Insert(entity = modelTech::class)
    public fun SetItemTech(item: modelTech)

    @Insert(entity = modelAud::class)
    public fun SetItemAud(item: modelAud)

    @Insert(entity = modelTime::class)
    public fun SetItemTime(item: modelTime)

    @Insert(entity = modelNameWeek::class)
    public fun SetItemNameWeek(item: modelNameWeek)

    @Query("SELECT num_group FROM GroupCollect")
    public fun GetItemNumGroup(): Flow<List<String>>

    @Query("SELECT name_day, time_begin, time_end, num_lesson, lesson, name_tech, name_aud" +
            " FROM GroupCollect, SH, Time, Tech, Aud" +
            " WHERE num_group = :num_group AND id_name_week = :id_name_week AND" +
                    " group_id = id_group AND" +
                    " num_lesson = time_id AND" +
                    " id_tech = tech_id AND" +
                    " aud_id = id_aud")
    public fun GetItemSH(num_group: String, id_name_week:Int): Flow<List<Lesson_info>>








}