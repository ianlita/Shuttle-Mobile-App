package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class ShuttlePassWithPassengerDto(
    val id: String,
    val driverId: String,
    val shuttleId: String,
    val routeId: String,
    val dateCreated: String,
    val tripType: String,
    val arrivalTime: String,
    val departureTime: String,
    val isLateShuttle: Boolean,

    val passengers: List<PassengerDto>,

    )
