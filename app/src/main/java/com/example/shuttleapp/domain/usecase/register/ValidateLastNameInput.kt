package com.example.shuttleapp.domain.usecase.register

import com.example.shuttleapp.domain.usecase.AuthValidationResult

class ValidateLastNameInput {

    fun execute(lastName: String) : AuthValidationResult {

        if(lastName.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Last name can't be blank"
            )
        }

        if (!lastName.matches(Regex("^[a-zA-Z\\.\\-]+$"))) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Should not contain numbers or special characters"
            )
        }

        return AuthValidationResult(
            successful = true
        )
    }
}