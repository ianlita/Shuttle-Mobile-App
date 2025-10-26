package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.ShuttleProviderEntity
import com.example.shuttleapp.data.network.response.ShuttleProviderDto
import com.example.shuttleapp.domain.model.ShuttleProvider

fun ShuttleProviderDto.toShuttleProviderEntity() : ShuttleProviderEntity {
    return ShuttleProviderEntity(
        shuttleProviderId = id ?: "",
        providerName = providerName ?: "",
        isActive = isActive ?: false
    )
}

fun ShuttleProviderEntity.toShuttleProvider() : ShuttleProvider {
    return ShuttleProvider(
        shuttleProviderId = shuttleProviderId,
        providerName = providerName
    )
}