package com.example.shuttleapp.domain.model

import java.util.UUID

data class Department(
    val id: String = UUID.randomUUID().toString(),
    val departmentName: String
)
