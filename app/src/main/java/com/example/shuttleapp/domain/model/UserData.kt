package com.example.shuttleapp.domain.model

data class UserData (
    val accountId: String,
    val empNo: String,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val providerId: String?
)