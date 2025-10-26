package com.example.shuttleapp.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class RoleDto(
    val roleid: Int?,
    val rolename: String?
)
