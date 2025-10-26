package com.example.shuttleapp.presentation.state

import com.example.shuttleapp.domain.model.RememberedUser

data class LoggedUserState(
    val loggedUser: RememberedUser? = null
)
