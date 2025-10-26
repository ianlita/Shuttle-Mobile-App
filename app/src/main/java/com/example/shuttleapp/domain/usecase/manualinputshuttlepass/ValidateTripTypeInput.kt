package com.example.shuttleapp.domain.usecase.manualinputshuttlepass

import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult

class ValidateTripTypeInput {

    fun execute(tripType: String) : ShuttlePassValidationResult {
        if(tripType.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Trip type can't be blank"
            )
        }
        val trips: List<String> = listOf("Incoming", "Outgoing")

        if(!trips.any { it.equals(tripType, ignoreCase = true) }) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Invalid trip"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }
}