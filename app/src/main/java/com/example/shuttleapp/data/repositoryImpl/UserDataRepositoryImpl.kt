package com.example.shuttleapp.data.repositoryImpl

import com.example.shuttleapp.data.mappers.toUserData
import com.example.shuttleapp.data.network.AuthApi
import com.example.shuttleapp.domain.model.UserData
import com.example.shuttleapp.domain.repository.UserDataRepository
import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class  UserDataRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val database: ShuttleDatabase
) : UserDataRepository {

    override suspend fun getProviderIdByAccountId(accountId: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(accountId: String): Flow<Resource<UserData>> {

        return flow {
            emit(Resource.Loading(true))

            val userDataEntity = database.UserDataDao().getUserById(accountId)
            emit(Resource.Success(data = userDataEntity.toUserData()))
            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun clearUserData() {
        database.UserDataDao().clearUserData()
    }

    override suspend fun getDriverNameById(id: String): Flow<String?> {
        return flow {
            val driver = database.UserDataDao().getDriverNameById(id)
            driver?.let {emit("${it.firstName} ${it.lastName}") }

        }.flowOn(Dispatchers.IO)
    }


    //        return flow {
//            emit(Resource.Loading(true))
//
//            val localUsers = database.UserDao().getAllUsers()
//            val shouldLoadLocalUsers = localUsers.isNotEmpty() && !forceFetchFromRemote
//
//            if(shouldLoadLocalUsers) { //here when load local users
//                emit(Resource.Success(
//                    data = localUsers.map { userEntity ->
//                        userEntity.toUser()
//                    }
//                ))
//
//                emit(Resource.Loading(false))
//                return@flow
//            }
//
//            val usersFromApi = try {
//                api.getCredentials()
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//                emit(Resource.Error("error fetching credentials from api"))
//                return@flow
//            } catch (ex: IOException) {
//                ex.printStackTrace()
//                emit(Resource.Error("error fetching credentials from api"))
//                return@flow
//            } catch (ex: HttpException) {
//                ex.printStackTrace()
//                emit(Resource.Error("error fetching credentials from api"))
//                return@flow
//            } finally {
//                emit(Resource.Loading(false))
//            }
//
//            //after fetching the credentials from api, save it to local storage
//            val userEntities = usersFromApi.let {
//                it.map { userDto ->
//                    userDto.toUserEntity()
//                }
//            }
//
//            database.UserDao().deleteAllUsers()
//            database.UserDao().insertUsers(userEntities)
//
//            emit(Resource.Success(data = userEntities.map { userEntity ->
//                userEntity.toUser()
//            }))
//            emit(Resource.Loading(false))
//
//

}