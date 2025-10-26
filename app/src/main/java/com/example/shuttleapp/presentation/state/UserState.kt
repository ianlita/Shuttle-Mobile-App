package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.domain.model.UserData

data class UserState(
    val isLoading: Boolean = false,
    val userData: UserData? = null,
    val error: String? = null
)
