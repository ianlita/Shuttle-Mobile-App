package com.example.shuttleapp.presentation.state

data class RouteState(
    val isLoading: Boolean = false,
    val routes: List<String> = emptyList(),
    val error: String? = null
)