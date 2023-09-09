package com.example.maddtutorial07.database

class UserRepository(
    private val db: UserDB
) {
    suspend fun insert(vararg user:User) = db.getUserDao().insert(*user)
    suspend fun update(vararg user:User) = db.getUserDao().update(*user)
    suspend fun delete(vararg user:User) = db.getUserDao().delete(*user)
    suspend fun getAll() = db.getUserDao().getAll()
    suspend fun getOne(name:String) = db.getUserDao().getOne(name)
}