package com.example.plannerproject

import androidx.room.Database
import com.example.plannerproject.data.ToDo

@Database(
    version = 1,
    entities = [ToDo::class]
)
abstract class ToDoDatabase {

    abstract val dao: ToDo

    companion object {
        const val name = "todo_db"
    }
}