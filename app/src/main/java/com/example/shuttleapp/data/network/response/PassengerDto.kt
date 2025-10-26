package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class PassengerDto(
    val id: String,
    val shuttlePassId: String?,
    val scannedQr: String?,
    val timeIn: String?,

    )
