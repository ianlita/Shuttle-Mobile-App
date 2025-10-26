package com.example.shuttleapp.domain.usecase.manualinputshuttlepass


import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult
import com.example.shuttleapp.util.containsNumber

class ValidateDriverInput {

    fun execute(driver: String) : ShuttlePassValidationResult {
        if(driver.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Driver can't be blank"
            )
        }
        if(driver.containsNumber()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Driver should not contain numbers"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }
}