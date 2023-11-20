package com.example.plannerproject

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    //also friends list

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * from users")
    suspend fun getUsers(): List<User>
}

    @Database (entities = [User::class],version = 6, exportSchema = false)
    abstract class UserDatabase: RoomDatabase(){
        abstract fun userDao(): UserDao
    }

