package com.example.shuttleapp.data.network.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterDto(

    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("middleName")
    val middleName: String?,
    @SerializedName("password")
    val password: String,
    @SerializedName("shuttleProviderId")
    val shuttleProviderId: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("employeeNumber")
    val employeeNumber: String,
    @SerializedName("roleId")
    val roleId: Int = 2
)
