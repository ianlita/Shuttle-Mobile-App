package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable


@Serializable
data class RegisterResponse(
    val status: Int,
    val title: String
)
