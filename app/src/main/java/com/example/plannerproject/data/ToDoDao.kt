package com.example.plannerproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo")
    fun getAllToDos(): Flow<List<ToDo>>

    @Query("""
        SELECT * FROM ToDo
        WHERE id = :id
    """)
    suspend fun getToDoById(id: Int): ToDo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Update
    suspend fun updateToDo(toDo: ToDo)
}