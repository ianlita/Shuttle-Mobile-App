package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "UserData",
    foreignKeys = [
        ForeignKey(
            entity = ShuttleProviderEntity::class,
            parentColumns = ["shuttleProviderId"],
            childColumns = ["shuttleProviderId"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [
        Index(value = ["shuttleProviderId"]),
        Index(value = ["accountId", "empNo", "shuttleProviderId"], unique = true)
    ]
)
data class UserDataEntity (

    @PrimaryKey
    val accountId: String,

    val empNo: String,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val shuttleProviderId: String?,

    )
