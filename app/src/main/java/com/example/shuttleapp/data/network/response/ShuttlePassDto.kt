package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable


@Serializable
data class ShuttlePassDto(

    val arrivaltime: String?,
    val datecreated: String?,
    val departuretime: String?,
    val driverid: String?,
    val islateshuttle: Boolean?,
)
