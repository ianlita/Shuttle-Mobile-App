package com.example.shuttleapp.domain.usecase.register

import com.example.shuttleapp.domain.usecase.AuthValidationResult


class ValidateMiddleNameInput {

    fun execute(middleName: String) : AuthValidationResult {

        if(middleName.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Middle name can't be blank"
            )
        }

        if (!middleName.matches(Regex("^[a-zA-Z\\.\\-]+$"))) {
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