package com.example.plannerproject

import androidx.room.*
import com.example.plannerproject.data.TodoDao
import kotlinx.coroutines.flow.Flow



    @Database (entities = [User::class],version = 9, exportSchema = false)
    abstract class TodoDatabase: RoomDatabase(){

    }

