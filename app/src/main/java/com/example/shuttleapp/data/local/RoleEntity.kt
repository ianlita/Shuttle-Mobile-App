package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "role")
data class RoleEntity(

    @PrimaryKey
    val roleId: Int,

    val roleName: String

)