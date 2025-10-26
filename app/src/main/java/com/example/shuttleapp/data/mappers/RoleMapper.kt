package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.RoleEntity
import com.example.shuttleapp.data.network.response.RoleDto
import com.example.shuttleapp.domain.model.Role

fun RoleDto.toRoleEntity() : RoleEntity {
    return RoleEntity(
        roleId = roleid ?: 0,
        roleName = rolename ?: ""
    )
}

fun RoleEntity.toRole() : Role {
    return Role(
        roleId = roleId,
        roleName = roleName
    )
}