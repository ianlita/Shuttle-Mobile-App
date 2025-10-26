package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class RouteDto(
    val id: String?,
    val code: String?,
    val routeName: String?
)
