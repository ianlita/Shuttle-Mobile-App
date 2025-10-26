package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "LoggedUser",
    indices = [
        Index(
            value = ["firstName","middleName","lastName","shuttleProviderId"],
            unique = true
        )
    ]
)
data class RememberedUserEntity(

    @PrimaryKey
    val accountId: String,

    val employeeNumber: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val shuttleProviderId: String,
    val isLoggedIn: Boolean,
    val isRemembered: Boolean
)