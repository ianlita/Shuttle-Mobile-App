package com.example.shuttleapp.presentation.state

data class ShuttleState(
    val isLoading: Boolean = false,
    val plateNumbers: List<String> = emptyList(),
    val error: String? = null
)
