package com.example.plannerproject.repository

import com.example.plannerproject.data.ToDo
import com.example.plannerproject.model.ToDoModel
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getAllToDos(): Flow<List<ToDoModel>>

    suspend fun getToDoById(id: Int): ToDoModel?

    suspend fun insertToDo(todomodel: ToDoModel)

    suspend fun deleteToDo(todomodel: ToDoModel)

    suspend fun updateToDo(todomodel: ToDoModel)
}