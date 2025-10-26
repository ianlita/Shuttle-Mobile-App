package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable


@Serializable
data class ShuttleDto(
    val id: String?,
    val plateNumber: String?,
    val providerId: String?
)