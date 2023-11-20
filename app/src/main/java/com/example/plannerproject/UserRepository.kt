package com.example.plannerproject

import kotlinx.coroutines.flow.Flow
interface UserRepository {
    suspend fun getUsers(): List<User>

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun updateUser(user: User)
}