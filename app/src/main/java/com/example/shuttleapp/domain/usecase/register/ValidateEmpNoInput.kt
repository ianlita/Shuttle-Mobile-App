package com.example.shuttleapp.domain.usecase.register

import com.example.shuttleapp.domain.usecase.AuthValidationResult

class ValidateEmpNoInput() {

    fun execute(employeeNumber: String) : AuthValidationResult {

        if(employeeNumber.isEmpty()) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Employee number can't be blank"
            )
        }

        //validation kung number only or letter only
        if(!employeeNumber.all{it.isDigit()}) {
            return AuthValidationResult(
                successful = false,
                errorMessage = "Employee number should contain digits only"
            )
        }

//        if(!employeeNumber.matches(Regex("^[0-9]+$"))) {
//            return AuthValidationResult(
//                successful = false,
//                errorMessage = "Employee number should contain digits only"
//            )
//        }

        return AuthValidationResult(
            successful = true
        )
    }
}
