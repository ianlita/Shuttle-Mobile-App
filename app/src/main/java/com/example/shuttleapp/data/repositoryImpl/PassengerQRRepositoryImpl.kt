package com.example.shuttleapp.data.repositoryImpl

import android.util.Log
import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.domain.repository.PassengerQRRepository
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PassengerQRRepositoryImpl @Inject constructor(
    private val database: ShuttleDatabase
) : PassengerQRRepository {

    override suspend fun insertPassengerQR(passenger: PassengerQREntity) {

        val draftIdResource = getDraftId()

        try {
            when(draftIdResource) {

                is Resource.Success -> {
                    val existingShuttlePassId = draftIdResource.data

                    if (!existingShuttlePassId.isNullOrEmpty()) {
                        val passengerWithShuttleId = passenger.copy(shuttlePassId = existingShuttlePassId)
                        database.PassengerQRDao().insertPassengerQR(passengerWithShuttleId)
                    } else {
                        return
                    }
                }
                is Resource.Error -> {

                    throw RuntimeException(draftIdResource.message)
                }
                else -> {
                    //loading
                }
            }
        } catch (ex: Exception) {
            Log.e("InsertPassengerQR", "Error inserting passenger", ex)
        }
    }

    override suspend fun updatePassengerQR(passenger: PassengerQREntity) {
        database.PassengerQRDao().updatePassengerQR(passenger)
    }

    override suspend fun deletePassengerQR(passenger: PassengerQREntity) {
        database.PassengerQRDao().deletePassengerQR(passenger)
    }

    override fun getPassengersQRByForeignKeyId(shuttlePassId: String): Flow<Resource<List<PassengerQREntity>>> {

        return flow {
            emit(Resource.Loading(true))

            val passengersQRList = database.PassengerQRDao().getPassengersQRByForeignKeyId(shuttlePassId).firstOrNull()

            emit(Resource.Success(data = passengersQRList))

            emit(Resource.Loading(false))
            return@flow
        }
    }

    override fun getDraftedPassengersQR(): Flow<Resource<List<PassengerQREntity>>> {

        return flow {
            emit(Resource.Loading(true))

            val draftedPassengers = database.PassengerQRDao().getDraftedPassengersQR().firstOrNull()
            emit(Resource.Success(data = draftedPassengers))

            emit(Resource.Loading(false))
            return@flow
        }
    }

    override fun getPassengerQRById(id: String): Flow<Resource<PassengerQREntity>> {

        return flow {
            emit(Resource.Loading(true))

            val passengerQR =  database.ShuttlePassDao().getPassengerById(id).firstOrNull()

            emit(Resource.Success(data = passengerQR))

            emit(Resource.Loading(false))
            return@flow
        }
    }

    override suspend fun getPassengerQRId(name: String, shuttlePassId: String): Resource<String?> {

        try {
            val data = database.PassengerQRDao().getPassengerQRId(name, shuttlePassId)
            return Resource.Success(data)
        }
        catch (ex : Exception) {
            return Resource.Error("error: ${ex.printStackTrace()}")
        }
    }

    override suspend fun getDraftId(): Resource<String?> {

        try {
            val data = database.PassengerQRDao().getDraftId()
            return Resource.Success(data)
        }
        catch (ex : Exception) {
            return Resource.Error("error: ${ex.printStackTrace()}")

        }

    }

    //upsert : create-update
    override suspend fun insertPassenger(passenger: PassengerQREntity) {
        database.PassengerQRDao().insertPassengerQR(passenger)
    }
    //edit
    override suspend fun updatePassenger(passenger: PassengerQREntity) {
        database.ShuttlePassDao().updatePassenger(passenger)
    }
    //delete
    override suspend fun deletePassenger(passenger: PassengerQREntity) {
        database.ShuttlePassDao().deletePassenger(passenger)
    }
    override fun getPassengersByForeignKeyId(shuttlePassId: String): Flow<List<PassengerQREntity>> {
        return database.ShuttlePassDao().getPassengersByForeignKeyId(shuttlePassId)
    }

    override fun getDraftedPassengers(shuttlePassId: String) : Flow<List<PassengerQREntity>> {
        return database.PassengerQRDao().getDraftedPassengers(shuttlePassId)
    }

    override fun getPassengerById(id: String) : Flow<PassengerQREntity> {
        return database.ShuttlePassDao().getPassengerById(id)
    }

    override suspend fun getPassengerId(name: String, shuttlePassId: String) : String? {
        return database.PassengerQRDao().getPassengerId(name, shuttlePassId)
    }

    override fun getScannedQRCodes(shuttlePassId: String) : Flow<List<String>> {
        return database.PassengerQRDao().getScannedQQRCodes(shuttlePassId)
    }





}