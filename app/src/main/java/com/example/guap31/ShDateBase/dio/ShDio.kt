package com.example.guap31.ShDateBase.dio

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.guap31.ShDateBase.model.GroupCollegeModel
import com.example.guap31.ShDateBase.model.modelSH
import com.example.guap31.adapter.SH_lesson_adapter.Lesson_info
import kotlinx.coroutines.flow.Flow


@Dao
interface ShDio {
    @Insert
    public fun insertDB(item: modelSH)

    @Query("SELECT * FROM Schedule")
    public fun getAllItem(): Flow<List<modelSH>>

    @Query("SELECT time_begin as beginTime, time_end as endTime, NumLesson as NumLesson, Mon as NameLesson, NameTeacher as NameTeacher, NumAudience as NumAudience\n" +
            "FROM GroupCollege, Schedule, TabMon, Audience, Teacher, Time\n" +
            "WHERE Number = :numberGroup AND WeekId = :WeekId AND\n" +
            "      idGroup = GroupId AND\n" +
            "      idMonKey = MonId AND\n" +
            "      idAudience = MonAudience AND\n" +
            "      idTeacher = MonTeacher AND\n" +
            "      idlesson = NumLesson")
    public fun getMonItem(numberGroup: String, WeekId: Int): Flow<List<Lesson_info>>

    @Query("SELECT time_begin as beginTime, time_end as endTime, NumLesson as NumLesson, Tue as NameLesson, NameTeacher as NameTeacher, NumAudience as NumAudience\n" +
            "FROM GroupCollege, Schedule, TabTue, Audience, Teacher, Time\n" +
            "WHERE Number = :numberGroup AND WeekId = :WeekId AND\n" +
            "      idGroup = GroupId AND\n" +
            "      idTueKey = TueId AND\n" +
            "      idAudience = TueAudience AND\n" +
            "      idTeacher = TueTeacher AND\n" +
            "      idlesson = NumLesson")
    public fun getTueItem(numberGroup: String, WeekId: Int): Flow<List<Lesson_info>>

    @Query("SELECT time_begin as beginTime, time_end as endTime, NumLesson as NumLesson, Wed as NameLesson, NameTeacher as NameTeacher, NumAudience as NumAudience\n" +
            "FROM GroupCollege, Schedule, TabWed, Audience, Teacher, Time\n" +
            "WHERE Number = :numberGroup AND WeekId = :WeekId AND\n" +
            "      idGroup = GroupId AND\n" +
            "      idWedKey = WedId AND\n" +
            "      idAudience = WedAudience AND\n" +
            "      idTeacher = WedTeacher AND\n" +
            "      idlesson = NumLesson")
    public fun getWedItem(numberGroup: String, WeekId: Int): Flow<List<Lesson_info>>

    @Query("SELECT time_begin as beginTime, time_end as endTime, NumLesson as NumLesson, Thu as NameLesson, NameTeacher as NameTeacher, NumAudience as NumAudience\n" +
            "FROM GroupCollege, Schedule, TabThu, Audience, Teacher, Time\n" +
            "WHERE Number = :numberGroup AND WeekId = :WeekId AND\n" +
            "      idGroup = GroupId AND\n" +
            "      idThuKey = ThuId AND\n" +
            "      idAudience = ThuAudience AND\n" +
            "      idTeacher = ThuTeacher AND\n" +
            "      idlesson = NumLesson")
    public fun getThuItem(numberGroup: String, WeekId: Int): Flow<List<Lesson_info>>

    @Query("SELECT time_begin as beginTime, time_end as endTime, NumLesson as NumLesson, Fri as NameLesson, NameTeacher as NameTeacher, NumAudience as NumAudience\n" +
            "FROM GroupCollege, Schedule, TabFri, Audience, Teacher, Time\n" +
            "WHERE Number = :numberGroup AND WeekId = :WeekId AND\n" +
            "      idGroup = GroupId AND\n" +
            "      idFriKey = FriId AND\n" +
            "      idAudience = FriAudience AND\n" +
            "      idTeacher = FriTeacher AND\n" +
            "      idlesson = NumLesson")
    public fun getFriItem(numberGroup: String, WeekId: Int): Flow<List<Lesson_info>>

    @Query("SELECT time_begin as beginTime, time_end as endTime, NumLesson as NumLesson, Sat as NameLesson, NameTeacher as NameTeacher, NumAudience as NumAudience\n" +
            "FROM GroupCollege, Schedule, TabSat, Audience, Teacher, Time\n" +
            "WHERE Number = :numberGroup AND WeekId = :WeekId AND\n" +
            "      idGroup = GroupId AND\n" +
            "      idSatKey = SatId AND\n" +
            "      idAudience = SatAudience AND\n" +
            "      idTeacher = SatTeacher AND\n" +
            "      idlesson = NumLesson")
    public fun getSatItem(numberGroup: String, WeekId: Int): Flow<List<Lesson_info>>

    @Query("SELECT Number FROM GroupCollege")
    public fun getGroupCollegeItem(): Flow<List<String>>


    @Query("INSERT INTO Schedule VALUES (:Id, :GroupId, :WeekId, :NumLesson, :MonId, :TueId, :WedId, :ThuId, :FriId, :SatId)")
    public fun setItemSchedule(Id: Int, GroupId: Int, WeekId: Int, NumLesson: Int, MonId: Int, TueId: Int, WedId: Int, ThuId: Int, FriId: Int, SatId: Int)

    @Query("INSERT INTO GroupCollege VALUES (:idGroup, :Number)")
    public fun setItemGroupCollege(idGroup: Int, Number: String)

    @Query("INSERT INTO TabMon VALUES (:idMonKey, :Mon, :MonAudience, :MonTeacher)")
    public fun setItemMon(idMonKey: Int, Mon: String, MonAudience: Int, MonTeacher: Int)

    @Query("INSERT INTO TabTue VALUES (:idTueKey, :Tue, :TueAudience, :TueTeacher)")
    public fun setItemTue(idTueKey: Int, Tue: String, TueAudience: Int, TueTeacher: Int)

    @Query("INSERT INTO TabWed VALUES (:idWedKey, :Wed, :WedAudience, :WedTeacher)")
    public fun setItemWed(idWedKey: Int, Wed: String, WedAudience: Int, WedTeacher: Int)

    @Query("INSERT INTO TabThu VALUES (:idThuKey, :Thu, :ThuAudience, :ThuTeacher)")
    public fun setItemThu(idThuKey: Int, Thu: String, ThuAudience: Int, ThuTeacher: Int)

    @Query("INSERT INTO TabFri VALUES (:idFriKey, :Fri, :FriAudience, :FriTeacher)")
    public fun setItemFri(idFriKey: Int, Fri: String, FriAudience: Int, FriTeacher: Int)

    @Query("INSERT INTO TabSat VALUES (:idSatKey, :Sat, :SatAudience, :SatTeacher)")
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