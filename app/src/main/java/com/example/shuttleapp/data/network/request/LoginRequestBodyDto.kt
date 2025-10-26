package com.example.shuttleapp.data.network.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestBodyDto(
    val username: String,
    val password: String
)