package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Route",
    indices= [
        Index(value = ["routeId","routeName","code"], unique = true)
    ]
)
data class RouteEntity(

    @PrimaryKey
    val routeId : String,

    val routeName : String,
    val code : String,



    )
