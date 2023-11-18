package com.example.plannerproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey val id: Int?,
    val task: String,
    val points: Int?
)
