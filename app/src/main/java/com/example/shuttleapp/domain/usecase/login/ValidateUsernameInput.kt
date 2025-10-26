package com.example.shuttleapp.domain.usecase.login

import com.example.shuttleapp.domain.usecase.AuthValidationResult

class ValidateUsernameInput {

    fun execute(username: String) : AuthValidationResult {

        if(username.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "username can't be blank"
            )
        }
//        if("." !in username) {
//            return AuthValidationResult(
//                successful = false,
//                errorMessage = "invalid username"
//            )
//        }

        return AuthValidationResult(
            successful = true
        )
    }
}