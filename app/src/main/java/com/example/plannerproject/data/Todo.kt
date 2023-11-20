package com.example.plannerproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    val points: Int,
    val isComplete: Boolean
)

