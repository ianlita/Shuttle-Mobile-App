package com.example.shuttleapp.domain.usecase.manualaddpassenger

import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult
import com.example.shuttleapp.util.containsNumber

class ValidateDepartmentInput() {

    fun execute(department: String, departments: List<String>) : ShuttlePassValidationResult {

        if(department.isBlank()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Department can't be blank"
            )
        }
        if(department.containsNumber()) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Invalid Department"
            )
        }
        if(!departments.contains(department)) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Department does not exist"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }


}