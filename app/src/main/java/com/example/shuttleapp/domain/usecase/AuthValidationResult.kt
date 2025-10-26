package com.example.shuttleapp.domain.usecase

data class AuthValidationResult (
    val successful: Boolean,
    val errorMessage: String? = null
)