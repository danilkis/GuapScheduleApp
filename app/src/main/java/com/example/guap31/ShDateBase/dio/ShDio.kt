package com.example.guap31.ShDateBase.dio

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.guap31.ShDateBase.model.modelSH
import kotlinx.coroutines.flow.Flow


@Dao
interface ShDio {
    @Insert
    public fun insertDB(item: modelSH)

    @Query("SELECT * FROM Schedule")
    public fun getAllItem(): Flow<List<modelSH>>

    @Query("INSERT INTO Schedule VALUES (:Id, :GroupId, :WeekId, :NumLesson, :Mon, :Tue, :Wed, :Thu, :Fri, :Sat)")
    public fun setItemSchedule(
        Id: Int, GroupId: Int, WeekId: Int, NumLesson: Int, Mon: Int, Tue: Int, Wed: Int, Thu: Int, Fri: Int, Sat: Int
    )

    @Query("INSERT INTO GroupCollege VALUES (:idGroup, :Number)")
    public fun setItemGroupCollege(idGroup: Int, Number: String)


    @Query("INSERT INTO Mon VALUES (:idMonKey, :Mon, :MonAudience, :MonTeacher)")
    public fun setItemMon(idMonKey: Int, Mon: String, MonAudience: Int, MonTeacher: Int)

    @Query("INSERT INTO Tue VALUES (:idTueKey, :Tue, :TueAudience, :TueTeacher)")
    public fun setItemTue(idTueKey: Int, Tue: String, TueAudience: Int, TueTeacher: Int)

    @Query("INSERT INTO Wed VALUES (:idWedKey, :Wed, :WedAudience, :WedTeacher)")
    public fun setItemWed(idWedKey: Int, Wed: String, WedAudience: Int, WedTeacher: Int)

    @Query("INSERT INTO Thu VALUES (:idThuKey, :Thu, :ThuAudience, :ThuTeacher)")
    public fun setItemThu(idThuKey: Int, Thu: String, ThuAudience: Int, ThuTeacher: Int)

    @Query("INSERT INTO Fri VALUES (:idFriKey, :Fri, :FriAudience, :FriTeacher)")
    public fun setItemFri(idFriKey: Int, Fri: String, FriAudience: Int, FriTeacher: Int)

    @Query("INSERT INTO Sat VALUES (:idSatKey, :Sat, :SatAudience, :SatTeacher)")
    public fun setItemSat(idSatKey: Int, Sat: String, SatAudience: Int, SatTeacher: Int)

    @Query("INSERT INTO NameWeek VALUES (:idWeek, :weekName)")
    public fun setItemNameWeek(idWeek: Int, weekName: String)

    @Query("INSERT INTO Teacher VALUES (:idTeacher, :NameTeacher)")
    public fun setItemTeacher(idTeacher: Int, NameTeacher: String)

    @Query("INSERT INTO Audience VALUES (:idAudience, :NumAudience)")
    public fun setItemAudience(idAudience: Int, NumAudience: String)

    @Query("INSERT INTO Time VALUES (:idlesson, :time_begin, :time_end)")
    public fun setItemTime(idlesson: Int, time_begin: String, time_end: String)


}