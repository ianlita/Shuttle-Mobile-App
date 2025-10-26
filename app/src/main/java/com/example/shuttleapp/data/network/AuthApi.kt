package com.example.shuttleapp.data.network

import com.example.shuttleapp.data.network.request.LoginRequestBodyDto
import com.example.shuttleapp.data.network.request.RegisterDto
import com.example.shuttleapp.data.network.response.LoginResponseBodyDto
import com.example.shuttleapp.data.network.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {



    //@POST("auth/login/")
    @POST("users/login/")
    suspend fun postLogin(
        @Body
        credentialDto: LoginRequestBodyDto

    ) : Response<LoginResponseBodyDto>

    //@POST("auth/register/")
    @POST("users/register/")
    suspend fun postRegister(
        @Body
        registerDto: RegisterDto
    ) : Response<RegisterResponse>

//    @PUT("users/forgotpassword/")
//    suspend fun forgotPassword(
//        @Body
//        id: String,
//        userData : UserDataDto
//    )


}