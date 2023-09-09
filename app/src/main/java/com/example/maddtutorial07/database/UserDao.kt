package com.example.maddtutorial07.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    suspend fun insert(vararg user: User)

    @Update
    suspend fun update(vararg user: User)

    @Delete
    suspend fun delete(vararg user: User)

    @Query("SELECT * FROM users")
    suspend fun getAll():List<User>

    @Query("SELECT * FROM users WHERE userName=:name")
    suspend fun getOne(name:String):User
}