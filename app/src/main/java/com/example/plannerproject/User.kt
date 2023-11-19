package com.example.plannerproject

import androidx.room.*

@Entity(tableName = "users")

class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userName: String,
    val score: Int,
    )