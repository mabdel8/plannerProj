package com.example.plannerproject

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    //also friends list

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (item: User)

    @Update suspend fun update(item: User)

    @Delete
    suspend fun delete(item: User)

    @Query("SELECT * from users WHERE id = :id")
    fun getItem(id: Int): Flow<User>

    @Query("SELECT * from users ORDER BY userName ASC")
    fun getAllItems(): Flow<List<User>>

}