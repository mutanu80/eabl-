package com.example.eabl.RoomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Member_Info_table")
data class Member (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "member_ID")
    var ID:Int,
    @ColumnInfo(name = "member_fullName")
    var fullName:String,
    @ColumnInfo(name = "member_email")
    var email:String,
    @ColumnInfo(name = "member_password")
    var password:String
)


