package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "shuttleProvider",
    indices = [
        Index(value = ["shuttleProviderId","providerName"], unique = true)
    ])
data class ShuttleProviderEntity(

    @PrimaryKey
    val shuttleProviderId: String,

    val providerName: String,
    val isActive: Boolean

)