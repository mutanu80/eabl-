package com.example.eabl.RoomDb

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {

    @Insert
    suspend fun insertMemberData(member: Member):Long
    @Update
    suspend fun updateMemberData(member: Member):Int
    @Delete
    suspend fun deleteMemberData(member: Member):Int
    @Query("DELETE FROM member_info_table")
    suspend fun deleteAll():Int
    @Query("SELECT * FROM member_info_table")
    fun getAllUserData(): Flow<List<Member>>
}