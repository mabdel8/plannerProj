package com.example.plannerproject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plannerproject.User
import com.example.plannerproject.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class FriendViewModel(itemsRepository: UserRepository) : ViewModel() {


    val friendUiState: StateFlow<FriendUiState> =
        itemsRepository.getAllUsersStream().map { FriendUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = FriendUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class FriendUiState(val itemList: List<User> = listOf())