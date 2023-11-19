package com.example.plannerproject


import android.content.Context
interface UserAppContainer {
    val userRepository: UserRepository
}

class UserAppDataContainer(private val context: Context) : UserAppContainer {
    override val userRepository: UserRepository by lazy {
       UserOfflineRepository(FriendDatabase.getDatabase(context).userDao())
    }
}