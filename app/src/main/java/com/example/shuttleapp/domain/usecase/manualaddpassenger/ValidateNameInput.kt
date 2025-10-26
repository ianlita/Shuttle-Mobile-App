package com.example.shuttleapp.domain.usecase.manualaddpassenger

import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult
import com.example.shuttleapp.util.containsNumber

class ValidateNameInput() {

    fun execute(name: String) : ShuttlePassValidationResult {
        if(name.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Full name can't be blank"
            )
        }
        if(name.containsNumber()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Full name should not contain numbers"
            )
        }


        return ShuttlePassValidationResult(
            successful = true
        )
    }


}