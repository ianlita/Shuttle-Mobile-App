package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.RouteEntity
import com.example.shuttleapp.data.network.response.RouteDto
import com.example.shuttleapp.domain.model.Route


fun RouteDto.toRouteEntity() : RouteEntity {

    return RouteEntity(
        routeId = id ?: "",
        routeName = routeName ?: "",
        code = code ?: ""
    )
}

fun RouteEntity.toRoute() : Route {

    return Route(
        code = code,
        routeid = routeId,
        routename = routeName
    )
}