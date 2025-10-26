package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.UserDataEntity
import com.example.shuttleapp.data.network.response.UserDataDto
import com.example.shuttleapp.domain.model.UserData

fun UserDataDto.toEntity() : UserDataEntity {

    return UserDataEntity(
        accountId = id ?: "",
        empNo = employeeNumber ?: "",
        firstName = firstName ?: "",
        lastName = lastName ?: "",
        middleName = middleName ?: "",
        shuttleProviderId = shuttleProvider?.id ?: ""
    )
}

fun UserDataEntity.toUserData() : UserData {

    return UserData(
        accountId = accountId,
        empNo = empNo,
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        providerId = shuttleProviderId

    )
}