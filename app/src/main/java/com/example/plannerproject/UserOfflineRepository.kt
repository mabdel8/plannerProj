package com.example.plannerproject

import kotlinx.coroutines.flow.Flow
import android.app.Application
import androidx.room.Room

class UserOfflineRepository(app: Application) : UserRepository{

        private val db: UserDatabase

        init {
            // create the database
            db = Room.databaseBuilder(app, UserDatabase::class.java, "user.db")
                .fallbackToDestructiveMigration()
                .build()
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
