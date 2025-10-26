package com.example.shuttleapp.domain.usecase.register

import com.example.shuttleapp.domain.usecase.AuthValidationResult

class ValidateProviderInput {

    fun execute(shuttleProvider: String, providersList: List<String>) : AuthValidationResult {

        if(shuttleProvider.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Shuttle provider can't be blank"
            )
        }

        if(!providersList.contains(shuttleProvider)) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Invalid shuttle provider"
            )
        }

        return AuthValidationResult(
            successful = true
        )
    }
}