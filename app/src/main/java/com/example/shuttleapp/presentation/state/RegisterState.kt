package com.example.shuttleapp.presentation.state

data class RegisterState(
    val firstName: String = "",
    val firstNameErrorMessage: String? = null,

    val middleName: String = "",
    val middleNameErrorMessage: String? = null,

    val lastName: String = "",
    val lastNameErrorMessage: String? = null,

    val provider: String = "",
    val providerErrorMessage: String? = null,

    val employeeNumber: String = "",
    val employeeNumberErrorMessage: String? = null,

    val userName: String = "",
    val userNameErrorMessage: String? = null,

    val password: String = "",
    val passwordErrorMessage: String? = null,

    val repeatPassword: String = "",
    val repeatPasswordErrorMessage: String? = null,

    val isValid: Boolean = false,
    val isPasswordShown: Boolean = false,
    val isRepeatPasswordShown: Boolean = false,
    val registerErrorMessage : String? = null,
    val isLoading: Boolean = false,

    val isSuccessfullyRegistered: Boolean = false,
)
