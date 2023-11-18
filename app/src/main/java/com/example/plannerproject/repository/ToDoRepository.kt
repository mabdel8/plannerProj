package com.example.plannerproject.repository

import com.example.plannerproject.data.ToDo
import com.example.plannerproject.model.ToDoModel
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getAllToDos(): Flow<List<ToDoModel>>

    suspend fun getToDoById(id: Int): ToDo?

    suspend fun insertToDo(todo: ToDo)

    suspend fun deleteToDo(todo: ToDo)

    suspend fun updateToDo(todo: ToDo)
}