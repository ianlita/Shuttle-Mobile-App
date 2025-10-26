package com.example.shuttleapp.domain.usecase.register

import com.example.shuttleapp.domain.usecase.AuthValidationResult

class ValidateRePasswordInput {

    fun execute(rePassword: String, password: String) : AuthValidationResult {

        if(rePassword.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Repeat password can't be blank"
            )
        }

        if(rePassword != password) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Password and repeat password do not match"
            )
        }

        return AuthValidationResult(
            successful = true
        )
    }
}