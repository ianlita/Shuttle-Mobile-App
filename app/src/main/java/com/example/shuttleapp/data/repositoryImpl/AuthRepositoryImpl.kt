package com.example.shuttleapp.data.repositoryImpl

import android.util.Log
import com.example.shuttleapp.data.mappers.toEntity
import com.example.shuttleapp.data.mappers.toShuttleProviderEntity
import com.example.shuttleapp.data.mappers.toUserData
import com.example.shuttleapp.data.network.AuthApi
import com.example.shuttleapp.data.network.request.LoginRequestBodyDto
import com.example.shuttleapp.data.network.request.RegisterDto
import com.example.shuttleapp.domain.model.UserData
import com.example.shuttleapp.domain.repository.AuthRepository
import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val database: ShuttleDatabase,
    //private val shuttleApi: ShuttleApi
) : AuthRepository {

    override suspend fun postLogin(credentialDto: LoginRequestBodyDto): Flow<Resource<UserData>> {

        return flow {
            emit(Resource.Loading(true))

            try {

                val response = authApi.postLogin(credentialDto)

                if (response.isSuccessful) {

                    val body = response.body()

                    if (body?.message == "login successful") {

                        //SAVE SHUTTLE PROVIDER
                        val shuttleProviderEntity = body.userData?.shuttleProvider?.toShuttleProviderEntity()
                        //insert first the shuttle provider
                        shuttleProviderEntity?.let { shuttleProvider ->
                            try {
                                database.ShuttleProviderDao().insertShuttleProvider(shuttleProvider)
                                Log.i("insertProvider", "shuttle provider inserted: $shuttleProviderEntity")
                            }catch (ex: Exception) {
                                ex.printStackTrace()
                                Log.e("insertProvider", "error inserting shuttleprovider:" + ex.message)
                            }
                        }

//                        try {
//                            //SAVE SHUTTLES (VEHICLES)
//                            val providerId = body.userdata?.providerid?.providerid
//
//                            providerId?.let{ it ->
//                                val shuttleFromApi = shuttleApi.getShuttlesByProviderId(it)
//
//                                val shuttleEntity = shuttleFromApi.map { it.toShuttleEntity() }
//                                database.ShuttleDao().clearAllShuttles()
//                                database.ShuttleDao().insertShuttle(shuttleEntity)
//                                Log.i("insertShuttle", "shuttle inserted: $shuttleEntity")
//
//                            }
//
//                        }catch (ex: Exception) {
//                            ex.printStackTrace()
//                            Log.e("insertShuttle", "error while managing the shuttles")
//                        }

                        // SAVE USER DATA
                        val userDataEntity = body.userData?.toEntity()
                        userDataEntity?.let { data ->
                            try{

                                database.UserDataDao().insertUserData(data)
                                Log.i("insertUserData", "user data inserted: $userDataEntity")

                            }
                            //android.database.sqlite.SQLiteConstraintException: FOREIGN KEY constraint failed (code 787 SQLITE_CONSTRAINT_FOREIGNKEY)
                            catch (ex:Exception) {
                                ex.printStackTrace()
                                Log.e("insertUserData", "error")
                            }
                        }
                        emit(Resource.Success(userDataEntity?.toUserData()))

                    } else {
                        emit(Resource.Error("Login failed. ${body?.message}"))
                    }
                } else {
                    emit(Resource.Error("Login error: ${response.message()}"))
                }
            }
            catch (ex: Exception) {
                //emit(Resource.Error("Exception: ${ex.localizedMessage}"))
                emit(Resource.Error("Connection failed. Cannot connect to server."))
                ex.printStackTrace()
            }


        }

    }

    override suspend fun postRegister(registerDto: RegisterDto) : Flow<Resource<String>> {

        return flow {
            emit(Resource.Loading(true))

            try {
                val response = authApi.postRegister(registerDto)

                if(response.isSuccessful) {

                    val body = response.body()

                    if(body?.status == 400) {
                        emit(Resource.Error(body.title))
                    }
                    else {
                        emit(Resource.Success(body?.title))
                    }
                }

            } catch (ex: Exception) {
                emit(Resource.Error("Connection failed. Cannot connect to server."))
                ex.printStackTrace()
            }
        }


    }
}