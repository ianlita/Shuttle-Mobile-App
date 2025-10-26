package com.example.shuttleapp.domain.repository

import com.example.shuttleapp.data.network.request.LoginRequestBodyDto
import com.example.shuttleapp.data.network.request.RegisterDto
import com.example.shuttleapp.domain.model.UserData
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun postLogin(credentialDto: LoginRequestBodyDto) : Flow<Resource<UserData>>

    suspend fun postRegister(registerDto: RegisterDto): Flow<Resource<String>>
}