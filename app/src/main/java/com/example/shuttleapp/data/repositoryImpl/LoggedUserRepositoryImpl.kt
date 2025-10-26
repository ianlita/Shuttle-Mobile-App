package com.example.shuttleapp.data.repositoryImpl

import android.util.Log
import com.example.shuttleapp.data.mappers.toRememberedUser
import com.example.shuttleapp.data.mappers.toLoggedUserEntity
import com.example.shuttleapp.domain.model.RememberedUser
import com.example.shuttleapp.domain.repository.RememberedUserRepository
import com.example.shuttleapp.config.ShuttleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoggedUserRepositoryImpl @Inject constructor(
    private val database: ShuttleDatabase
) : RememberedUserRepository {

    override suspend fun insertRememberedUser(loggedUser: RememberedUser) {

        val loggedUserEntity = loggedUser.toLoggedUserEntity()
        database.RememberedUserDao().insertLoggedUser(loggedUserEntity)
        Log.i("SaveLoginToTbl", "Success: ${loggedUserEntity.firstName}, remembered: ${loggedUserEntity.isRemembered}")
    }

    override fun getRememberedUser() : Flow<RememberedUser> {

        return flow {
            try {

                val loggedUser = database.RememberedUserDao().getRememberedUser()?.toRememberedUser()

                if(loggedUser != null) {
                    emit(loggedUser)
                }

                return@flow
            }
            catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)

    }

    override fun getLoggedUser() : Flow<RememberedUser> {

        return flow {
            try {

                val loggedUser = database.RememberedUserDao().getLoggerUser()?.toRememberedUser()

                if(loggedUser != null) {
                    emit(loggedUser)
                }

                return@flow
            }
            catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)

    }


    override suspend fun deleteRememberedUser() {
        database.RememberedUserDao().deleteLoggedUser()
    }


}