//package com.example.shuttle.authmodule.domain.usecase.register
//
//import com.example.shuttle.authmodule.domain.usecase.validationresult.RegisterValidationResult
//import com.example.shuttle.util.containsNumber
//import com.example.shuttle.util.containsSpecialChar
//import com.example.shuttle.util.containsUpperCase
//
//class ValidateRegisterInput {
//
//    operator fun invoke(email: String, password: String, repeatPassword: String) : RegisterValidationResult {
//
//        if(email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
//            return RegisterValidationResult.EmptyField
//        }
//        if("@" !in email) {
//            return RegisterValidationResult.NoEmail
//        }
//        if(password != repeatPassword) {
//            return RegisterValidationResult.PasswordDoNotMatch
//        }
//        if(password.length < 8) {
//            return RegisterValidationResult.PasswordTooShort
//        }
//        if(!password.containsNumber()) {
//            return RegisterValidationResult.PasswordNumberMissing
//        }
//        if(!password.containsUpperCase()) {
//            return RegisterValidationResult.PasswordUpperCaseMissing
//        }
//        if(!password.containsSpecialChar()) {
//            return RegisterValidationResult.PasswordSpecialCharMissing
//        }
//        return RegisterValidationResult.Valid
//    }
//}
//

