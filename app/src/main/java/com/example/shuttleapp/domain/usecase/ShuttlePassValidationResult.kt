package com.example.shuttleapp.domain.usecase

data class ShuttlePassValidationResult(

    val successful: Boolean,
    val errorMessage: String? = null
)
