package com.example.shuttleapp.domain.model

data class RememberedUser(
    val id: String,
    val employeeNumber: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val shuttleProviderId: String?,
    val isLoggedIn: Boolean,
    val isRemembered: Boolean
)
