package com.example.shuttleapp.presentation.events

sealed class RegisterInputEvent {

    data class FirstnameChanged(val firstname: String) : RegisterInputEvent()
    data class MiddlenameChanged(val middlename: String) : RegisterInputEvent()
    data class LastnameChanged(val lastname: String) : RegisterInputEvent()
    data class ProviderChanged(val provider: String) : RegisterInputEvent()
    data class EmployeeNumberChanged(val empNumber: String) : RegisterInputEvent()
    data class UsernameChanged(val username: String) : RegisterInputEvent()
    data class PasswordChanged(val password: String) : RegisterInputEvent()
    data class RePasswordChanged(val rePassword: String) : RegisterInputEvent()
    data class PasswordShown(val isPasswordShown: Boolean) : RegisterInputEvent()
    data class RePasswordShown(val isRePasswordShown: Boolean) : RegisterInputEvent()

    data object Submit : RegisterInputEvent()

}
