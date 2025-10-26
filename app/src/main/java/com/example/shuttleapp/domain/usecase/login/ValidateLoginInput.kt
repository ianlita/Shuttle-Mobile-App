package com.example.shuttleapp.domain.usecase.login

import com.example.shuttleapp.domain.usecase.AuthValidationResult

class ValidateLoginInput {

    fun execute(username: String, password: String) : AuthValidationResult {

        if(username.isEmpty() || password.isEmpty() ) {
            return AuthValidationResult(
                errorMessage = "username and password can't be blank",
                successful = false,
            )
        }

        if("." !in username ) {
            return AuthValidationResult(
                errorMessage = "Invalid credentials",
                successful = false,
            )
        }

        return AuthValidationResult(
            successful = true
        )
    }
}