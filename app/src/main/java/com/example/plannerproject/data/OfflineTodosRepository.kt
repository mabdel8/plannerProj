package com.example.plannerproject.data

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.flow.Flow

class OfflineTodosRepository(app: Application) : TodosRepository{

    private val db: TodoDatabase

    init {
        // create the database
        db = Room.databaseBuilder(app, TodoDatabase::class.java, "todo.db")
            .fallbackToDestructiveMigration()
            .build()
    }
    override fun getTodos(): List<Todo> {
        return db.todoDao().getTodos()
    }

    override suspend fun insertTodo(todo: Todo) {
        db.todoDao().insert(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        db.todoDao().delete(todo)
    }

    override suspend fun update(todo: Todo) {
        db.todoDao().update(todo)
    }

}