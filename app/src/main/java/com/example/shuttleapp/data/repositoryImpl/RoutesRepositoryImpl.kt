package com.example.shuttleapp.data.repositoryImpl

import coil.network.HttpException
import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.data.mappers.toRoute
import com.example.shuttleapp.data.mappers.toRouteEntity
import com.example.shuttleapp.data.network.ShuttleApi
import com.example.shuttleapp.domain.model.Route
import com.example.shuttleapp.domain.repository.RoutesRepository
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import javax.inject.Inject

class RoutesRepositoryImpl @Inject constructor(
    private val api : ShuttleApi,
    private val database: ShuttleDatabase
) : RoutesRepository {


//    override suspend fun getAllRoutes(forceFetchFromRemote: Boolean): Flow<Resource<List<Route>>> {
//
//
//        return flow {
//            emit(Resource.Loading(true))
//
//            val localRoutes = database.RoutesDao().getAllRoutes()
//
//            val shouldLoadLocalRoutes = localRoutes.isNotEmpty() && !forceFetchFromRemote
//
//            if(shouldLoadLocalRoutes) {
//                emit(Resource.Success(
//                    data = localRoutes.map { routeEntity ->
//                        routeEntity.toRoute()
//                    }
//                ))
//
//                emit(Resource.Loading(false))
//                return@flow
//            }
//
//            val routesFromApi = try {
//                api.getRoutes()
//
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//                emit(Resource.Error("error fetching routes from api"))
//                return@flow
//            } catch (ex: IOException) {
//                ex.printStackTrace()
//                emit(Resource.Error("error fetching routes from api"))
//                return@flow
//            } catch (ex: HttpException) {
//                ex.printStackTrace()
//                emit(Resource.Error("error fetching routes from api"))
//                return@flow
//            } finally {
//                emit(Resource.Loading(false))
//            }
//
//            //after fetching the routes from api, save it to local storage
//            val routeEntities = routesFromApi.let {
//                it.map { routeDto ->
//                    routeDto.toRouteEntity()
//                }
//            }
//
//            database.RoutesDao().clearAllRoutes() //clear existing routes first
//            //insert all items in the list in the routes table in each row. (1 row = 1 list item
//            database.RoutesDao().insertRoute(routeEntities)
//
//            //emit
//            emit(Resource.Success(data = routeEntities.map { routeEntity ->
//                routeEntity.toRoute()
//            }))
//            emit(Resource.Loading(false))
//
//        }
//    }

    override suspend fun getRouteById(id: String): Flow<Resource<Route>> {

        return flow {
            emit(Resource.Loading(true))

            val routeEntity = database.RoutesDao().getRouteById(id)

            if(routeEntity != null) {
                emit(
                    Resource.Success(data = routeEntity.toRoute())
                )

                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Error("Error. No such route"))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getRouteIdByName(routeName: String): String {
        return database.RoutesDao().getRouteIdByName(routeName)
    }

    override suspend fun getRouteNameById(id: String): String {
        return database.RoutesDao().getNameByRouteId(id)
    }

    override suspend fun getNameByRouteId(id: String): Flow<String> {
        return flow {
            emit(database.RoutesDao().getNameByRouteId(id))
        }.flowOn(Dispatchers.IO)
    }

    //update route from time to time when online
    override suspend fun getAllRoutes(forceFetchFromRemote: Boolean): Flow<Resource<List<Route>>> {

        //todo delete mo yung pre-fetch na routes tapos fetch ng bago para maaupdate yung routes if
        // may changes ang routes sa backend (delete first, then insert sa entity)

        return flow {
            emit(Resource.Loading(true))

            val localRoutes = database.RoutesDao().getAllRoutes()

            val shouldLoadLocalRoutes = localRoutes.isNotEmpty() && !forceFetchFromRemote

            if(shouldLoadLocalRoutes) {
                emit(Resource.Success(
                    data = localRoutes.map { routeEntity ->
                        routeEntity.toRoute()
                    }
                ))

                emit(Resource.Loading(false))
                //return@flow

            }
            //put in else blcok if you want to run this this if online first and the table route is empty
            try {
                val routesFromApi = api.getRoutes()
                val routeEntities = routesFromApi.map { it.toRouteEntity() }

                if(routeEntities != localRoutes) {
                    database.RoutesDao().clearAllRoutes() //clear existing routes first
                    //insert all items in the list in the routes table in each row. (1 row = 1 list item
                    database.RoutesDao().insertRoute(routeEntities)

                    //emit
                    emit(Resource.Success(data = routeEntities.map { routeEntity ->
                        routeEntity.toRoute()
                    }))
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                emit(Resource.Error("error fetching routes from api"))
            } catch (ex: IOException) {
                ex.printStackTrace()
                emit(Resource.Error("error fetching routes from api"))
            } catch (ex: HttpException) {
                ex.printStackTrace()
                emit(Resource.Error("error fetching routes from api"))
            } finally {
                emit(Resource.Loading(false))
            }

        }
    }
}