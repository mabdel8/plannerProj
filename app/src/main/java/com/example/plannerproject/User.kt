package com.example.plannerproject

import androidx.room.*
import java.util.UUID

@Entity(tableName = "users")

class User (
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val userName: String,
    val score: Int,
    )