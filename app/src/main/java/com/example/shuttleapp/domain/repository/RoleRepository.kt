package com.example.shuttleapp.domain.repository


import com.example.shuttleapp.domain.model.Role
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface RoleRepository {

    suspend fun getAllRoles(forceFetchFromRemote: Boolean) : Flow<Resource<List<Role>>>

    suspend fun getRoleById(id: Int) : Flow<Resource<Role>>
}