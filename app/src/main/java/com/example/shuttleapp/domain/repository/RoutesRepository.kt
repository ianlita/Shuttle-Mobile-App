package com.example.shuttleapp.domain.repository

import com.example.shuttleapp.domain.model.Route
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface RoutesRepository {

    suspend fun getAllRoutes(
        forceFetchFromRemote : Boolean
    ) : Flow<Resource<List<Route>>>

    suspend fun getRouteById(id: String) : Flow<Resource<Route>>

    suspend fun getRouteIdByName(routeName: String) : String

    suspend fun getNameByRouteId(id: String) : Flow<String>

    suspend fun getRouteNameById(id: String): String //



}