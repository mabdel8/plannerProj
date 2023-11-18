package com.example.plannerproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.plannerproject.data.ToDo

@Database(
    version = 1,
    entities = [ToDo::class]
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun dao(): ToDo

    companion object {
        const val name = "todo_db"
    }
}