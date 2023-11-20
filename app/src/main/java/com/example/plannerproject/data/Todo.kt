package com.example.plannerproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "todos")
class Todo(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val task: String,
    val points: Int,
    val isComplete: Boolean
)

