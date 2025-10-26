package com.example.shuttleapp.domain.usecase.manualinputshuttlepass

import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult

class ValidatePlateNumberInput {

    fun execute(plateNumber: String, plateNumbers: List<String>) : ShuttlePassValidationResult {
        if(plateNumber.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Plate number can't be blank"
            )
        }
        if(!plateNumbers.any { it.equals(plateNumber, ignoreCase = true) }) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Plate Number does not exist"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }
}