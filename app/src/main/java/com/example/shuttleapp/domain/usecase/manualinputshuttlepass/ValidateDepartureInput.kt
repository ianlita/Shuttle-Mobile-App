package com.example.shuttleapp.domain.usecase.manualinputshuttlepass

import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult
import com.example.shuttleapp.util.containsUpperCase

class ValidateDepartureInput {

    fun execute(departure: String) : ShuttlePassValidationResult {
        if(departure.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Full name can't be blank"
            )
        }
        if(departure.containsUpperCase() || departure.containsUpperCase()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Invalid departure"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }
}