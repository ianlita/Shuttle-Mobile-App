package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable


@Serializable
data class UserDataDto(
    val id: String?,
    val employeeNumber: String?,
    val firstName: String?,
    val lastName: String?,
    val middleName: String?,
    val shuttleProvider: ShuttleProviderDto?
)
