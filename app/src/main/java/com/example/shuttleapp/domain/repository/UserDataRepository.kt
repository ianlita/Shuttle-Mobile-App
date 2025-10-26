package com.example.shuttleapp.domain.repository

import com.example.shuttleapp.domain.model.UserData
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    suspend fun getProviderIdByAccountId(accountId: String) : String

    suspend fun getUserById(accountId: String) : Flow<Resource<UserData>>

    suspend fun clearUserData()

    suspend fun getDriverNameById(id: String) : Flow<String?>

}