package com.example.plannerproject

import kotlinx.coroutines.flow.Flow
interface UserRepository {
    fun getAllUsersStream(): Flow<List<User>>

    fun getUserStream(id: Int): Flow<User?>
    suspend fun insertUser(item: User)

    suspend fun deleteUser(item: User)

    suspend fun updateUser(item: User)
}