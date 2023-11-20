package com.example.plannerproject

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plannerproject.*
import kotlinx.coroutines.launch
import java.util.UUID

class FriendViewModel(app: Application) : AndroidViewModel(app) {
    private val _users: MutableState<List<User>> = mutableStateOf(listOf())
    val users: State<List<User>> = _users

    private val _waiting: MutableState<Boolean>
    val waiting: State<Boolean>

    val testFriend = User(UUID.randomUUID(),"TestFriend1",20)


    private val _repository: UserRepository = UserOfflineRepository(getApplication())

    init {
        viewModelScope.launch {
            _repository.insertUser(testFriend)
            _users.value = _repository.getUsers()
        }


        _waiting = mutableStateOf(false)
        waiting = _waiting
    }


    fun addUser(user: User) {
        viewModelScope.launch {
            _waiting.value = true
            _repository.insertUser(user)
            _users.value = _repository.getUsers()
            _waiting.value = false
        }
    }

    suspend fun deleteUser(user: User) {
        _repository.deleteUser(user)
        _users.value = _repository.getUsers()
    }

}