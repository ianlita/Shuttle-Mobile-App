package com.example.shuttleapp.domain.usecase.manualinputshuttlepass

import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult

class ValidateShuttleProviderInput {

    fun execute(shuttleProvider: String, providers: List<String>) : ShuttlePassValidationResult {
        if(shuttleProvider.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Full name can't be blank"
            )
        }
        if(!providers.any { it.equals(shuttleProvider, ignoreCase = true) }) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Shuttle provider does not exist"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }
}