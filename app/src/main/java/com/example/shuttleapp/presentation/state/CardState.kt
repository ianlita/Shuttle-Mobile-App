package com.example.shuttleapp.presentation.state

data class CardState(
    val passengerCount: Int = 0,
    val lateShuttleCount: Int = 0,
    val unsyncedShuttleCount: Int = 0,
    val currentRoute: String? = "",
    val tripType: String? = ""
)
