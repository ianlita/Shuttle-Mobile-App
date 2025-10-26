package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable


@Serializable
data class LoginResponseBodyDto(
    val message: String?,
    val userData: UserDataDto?
)
