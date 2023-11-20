package com.example.plannerproject.data

import kotlinx.coroutines.flow.Flow

interface TodosRepository {
    suspend fun getTodos(): List<Todo>

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun update(todo: Todo)
}