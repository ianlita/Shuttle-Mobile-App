package com.example.shuttleapp.domain.usecase.login


import com.example.shuttleapp.domain.usecase.AuthValidationResult


class ValidatePasswordInput {

    fun execute(password: String) : AuthValidationResult {
        if(password.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "password can't be blank"
            )
        }
        return AuthValidationResult(
            successful = true
        )
    }

}