package com.example.maddtutorial07.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDB:RoomDatabase() {
    abstract fun getUserDao():UserDao

    companion object{
        @Volatile
        private var INSTANCE:UserDB? =null

        fun getInstance(context: Context):UserDB{
            synchronized(this){
                return INSTANCE?:Room.databaseBuilder(
                    context.applicationContext,
                    UserDB::class.java,
                    "user_db",
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}