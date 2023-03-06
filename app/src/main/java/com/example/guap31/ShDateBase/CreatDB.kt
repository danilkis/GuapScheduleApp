package com.example.guap31.ShDateBase

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.guap31.ShDateBase.dio.ShDio
import com.example.guap31.ShDateBase.model.*


@Database(entities = [
    modelSH::class, GroupCollegeModel::class, NameWeekModel::class, TeacherModel::class, AudienceModel::class, TimeModel::class,
    MonModel::class, TueModel::class, WedModel::class,
    ThuModel::class, FriModel::class, SatModel::class], version = 1)
abstract class CreatDB: RoomDatabase() {
    abstract fun getDao(): ShDio
    companion object{
        fun getDateBase(context: Context): CreatDB{
            return Room.databaseBuilder(
                context.applicationContext,
                CreatDB::class.java,
                "SH.db"
            ).build()
        }
    }
}