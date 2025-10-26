package com.example.shuttleapp.domain.usecase.register

import com.example.shuttleapp.domain.usecase.AuthValidationResult


class ValidateFirstNameInput {

    fun execute(firstName: String) : AuthValidationResult {

        if(firstName.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "First name can't be blank"
            )
        }

        if (!firstName.matches(Regex("^[a-zA-Z\\.\\-]+$"))) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Should not contain numbers or special characters except - and ."
            )
        }

        return AuthValidationResult(
            successful = true
        )
    }
}