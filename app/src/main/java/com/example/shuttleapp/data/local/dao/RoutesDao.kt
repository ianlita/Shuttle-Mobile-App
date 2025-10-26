package com.example.shuttleapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.shuttleapp.data.local.RouteEntity


@Dao
interface RoutesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoute(routes: List<RouteEntity>)

    @Transaction
    @Query("SELECT * from Route")
    suspend fun getAllRoutes() : List<RouteEntity>

    @Transaction
    @Query("SELECT * from Route WHERE routeId = :id")
    suspend fun getRouteById(id: String) : RouteEntity

    @Transaction
    @Query("DELETE FROM Route")
    suspend fun clearAllRoutes()

    @Transaction
    @Query("SELECT routeId from Route WHERE routeName = :routeName")
    suspend fun getRouteIdByName(routeName: String) : String


    @Transaction
    @Query("SELECT routeName from Route WHERE routeId = :id")
    suspend fun getNameByRouteId(id: String) : String



}