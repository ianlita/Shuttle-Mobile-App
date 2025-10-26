package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.network.response.LoginResponseBodyDto
import com.example.shuttleapp.domain.model.LoginResponse
import com.example.shuttleapp.domain.model.UserData


fun LoginResponseBodyDto.toLoginResponse() : LoginResponse {

    return LoginResponse(
        message = message ?: "",
        userdata = userData?.toEntity()?.toUserData() ?: UserData(
            accountId = "",
            empNo = "",
            firstName = "",
            lastName = "",
            middleName = "",
            providerId = ""
        )
    )
}