package com.example.maddtutorial07.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    var userName:String?,
    var password:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
