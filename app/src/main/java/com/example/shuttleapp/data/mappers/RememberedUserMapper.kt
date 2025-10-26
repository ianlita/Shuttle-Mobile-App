package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.RememberedUserEntity
import com.example.shuttleapp.domain.model.RememberedUser

fun RememberedUserEntity.toRememberedUser() : RememberedUser {

    return RememberedUser(
        id = accountId,
        employeeNumber = employeeNumber,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        shuttleProviderId = shuttleProviderId,
        isLoggedIn = isLoggedIn,
        isRemembered = isRemembered
    )

}

fun RememberedUser.toLoggedUserEntity() : RememberedUserEntity {

    return RememberedUserEntity(
        accountId = id,
        employeeNumber = employeeNumber,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        shuttleProviderId = shuttleProviderId,
        isLoggedIn = isLoggedIn,
        isRemembered = isRemembered
    )
}