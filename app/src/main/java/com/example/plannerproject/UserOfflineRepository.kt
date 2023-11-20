package com.example.plannerproject

import kotlinx.coroutines.flow.Flow
class UserOfflineRepository( private val userDao: UserDao) : UserRepository{

    override fun getAllUsersStream(): Flow<List<User>> = userDao.getAllItems()

    override fun getUserStream(id: Int): Flow<User?> = userDao.getItem(id)

    override suspend fun insertUser(item: User) = userDao.insert(item)

    override suspend fun deleteUser(item: User) = userDao.delete(item)

    override suspend fun updateUser(item: User) = userDao.update(item)

}