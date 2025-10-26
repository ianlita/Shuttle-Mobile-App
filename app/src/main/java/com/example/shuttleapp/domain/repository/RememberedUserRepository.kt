package com.example.shuttleapp.domain.repository

import com.example.shuttleapp.domain.model.RememberedUser
import kotlinx.coroutines.flow.Flow

interface RememberedUserRepository {

    suspend fun insertRememberedUser(loggedUser: RememberedUser)
    fun getRememberedUser(): Flow<RememberedUser>
    suspend fun deleteRememberedUser()
    fun getLoggedUser(): Flow<RememberedUser>
}