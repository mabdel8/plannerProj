package com.example.plannerproject

import kotlinx.coroutines.flow.Flow
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.plannerproject.data.TodoDatabase

class UserOfflineRepository(app: Application, private val context: Context) : UserRepository{

        private val db: TodoDatabase

        init {
            // create the database
            db = TodoDatabase.getDatabase(context)
        }
        override suspend fun getUsers(): List<User> {
            return db.userDao().getUsers()
        }

        override suspend fun insertUser(user: User) {
            db.userDao().insert(user)
        }

        override suspend fun deleteUser(user: User) {
            db.userDao().delete(user)
        }

        override suspend fun updateUser(user: User) {
            db.userDao().update(user)
        }

    }
