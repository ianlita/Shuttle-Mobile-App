package com.example.shuttleapp.domain.repository

import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface PassengerQRRepository {

    suspend fun insertPassengerQR(passenger: PassengerQREntity)

    suspend fun updatePassengerQR(passenger: PassengerQREntity)

    suspend fun deletePassengerQR(passenger: PassengerQREntity)

    fun getPassengersQRByForeignKeyId(shuttlePassId: String): Flow<Resource<List<PassengerQREntity>>>

    fun getDraftedPassengersQR() : Flow<Resource<List<PassengerQREntity>>>

    fun getPassengerQRById(id: String) : Flow<Resource<PassengerQREntity>>

    suspend fun getPassengerQRId(name: String, shuttlePassId: String) : Resource<String?>

    suspend fun getDraftId() : Resource<String?>

    suspend fun getPassengerId(name: String, shuttlePassId: String) : String?

    fun getScannedQRCodes(shuttlePassId: String) : Flow<List<String>>

    fun getDraftedPassengers(shuttlePassId: String) : Flow<List<PassengerQREntity>>

    fun getPassengerById(id: String) : Flow<PassengerQREntity>

    fun getPassengersByForeignKeyId(shuttlePassId: String): Flow<List<PassengerQREntity>>

    suspend fun deletePassenger(passenger: PassengerQREntity)

    suspend fun updatePassenger(passenger: PassengerQREntity)

    suspend fun insertPassenger(passenger: PassengerQREntity)
}