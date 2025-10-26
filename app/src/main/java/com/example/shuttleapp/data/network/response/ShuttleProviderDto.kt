package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable


@Serializable
data class ShuttleProviderDto(
    val id: String?,
    val isActive: Boolean?, //todo delete this and all of the things that reference this
    val providerName: String?
)