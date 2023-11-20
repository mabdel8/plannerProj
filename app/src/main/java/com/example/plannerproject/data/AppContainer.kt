package com.example.plannerproject.data

import android.content.Context

interface AppContainer {
    val todosRepository: TodosRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val todosRepository: TodosRepository by lazy {
        OfflineTodosRepository(TodoDatabase.getDatabase(context).TodoDao())
    }
}