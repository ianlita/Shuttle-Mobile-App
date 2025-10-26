package com.example.shuttleapp.data.repositoryImpl

import com.example.shuttleapp.domain.model.Role
import com.example.shuttleapp.domain.repository.RoleRepository
import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.data.network.ShuttleApi
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoleRepositoryImpl @Inject constructor(
    private val api : ShuttleApi,
    private val database: ShuttleDatabase
) : RoleRepository {

    override suspend fun getAllRoles(forceFetchFromRemote: Boolean): Flow<Resource<List<Role>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRoleById(id: Int): Flow<Resource<Role>> {
        TODO("Not yet implemented")
    }

}