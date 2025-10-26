package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "shuttles",
    foreignKeys = [
        ForeignKey(
            entity = ShuttleProviderEntity::class,
            parentColumns = ["shuttleProviderId"],
            childColumns = ["shuttleProviderId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["shuttleProviderId"]),
        Index(value = ["shuttleId","plateNumber"], unique = true)
    ]
)
data class ShuttleEntity(

    @PrimaryKey
    val shuttleId: String,

    val plateNumber: String,
    val shuttleProviderId: String,
)
