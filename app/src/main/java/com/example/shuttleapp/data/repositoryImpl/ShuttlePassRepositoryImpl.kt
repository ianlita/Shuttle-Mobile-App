package com.example.shuttleapp.data.repositoryImpl

import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.data.local.ShuttlePassEntity
import com.example.shuttleapp.data.local.ShuttlePassWithPassengerEntity
import com.example.shuttleapp.data.network.ShuttleApi
import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerDto
import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerResponseBodyDto
import com.example.shuttleapp.domain.repository.ShuttlePassRepository
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.inject.Inject

class ShuttlePassRepositoryImpl @Inject constructor(
    private val api : ShuttleApi,
    private val database: ShuttleDatabase
) : ShuttlePassRepository {

    override suspend fun insertShuttlePass(shuttlePass: ShuttlePassEntity) {

        database.ShuttlePassDao().insertShuttlePass(shuttlePass)
    }

    override suspend fun updateShuttlePass(shuttlePass: List<ShuttlePassEntity>) {
        database.ShuttlePassDao().updateShuttlePass(shuttlePass)
    }

    //delete
    override suspend fun  deleteShuttlePassById(id: String) {
        return database.ShuttlePassDao().deleteShuttlePassById(id)
    }

    override suspend fun deleteShuttlePassOnDue(driverId: String): Int {
        return database.ShuttlePassDao().deleteShuttlePassOnDue(driverId)

    }

    override suspend fun getAllUnsyncedShuttlePasses(driverId: String) : List<ShuttlePassWithPassengerEntity> {
        return database.ShuttlePassDao().getAllUnsyncedShuttlePasses(driverId)
    }

    override suspend fun deleteAllDraftedShuttlePass(accountId: String) : Int {
        return database.ShuttlePassDao().deleteAllDraftedShuttlePass(accountId)
    }

    override suspend fun finalizeShuttleDraft(driverId: String, shuttlePass: ShuttlePassEntity, passengers : List<PassengerQREntity>) {
        val existingShuttlePassId = getShuttlePassIdDraftByDriverId(driverId)
        if (existingShuttlePassId != null) {
            val updatedShuttlePass = listOf(shuttlePass.copy(id = existingShuttlePassId, isDraft = false))
            val updatedPassengers = passengers.map { it.copy(shuttlePassId = existingShuttlePassId, isDraft = false) }
            database.ShuttlePassDao().updateShuttlePass(updatedShuttlePass)
            database.ShuttlePassDao().updatePassengers(updatedPassengers)
        } else {
            // Handle the case where there is no draft shuttle pass
            return
        }
    }

    override fun getAllShuttlePassWithPassengers(driverId: String) : Flow<List<ShuttlePassWithPassengerEntity>> {
        return database.ShuttlePassDao().getAllShuttlePassWithPassengers(driverId)
    }

    override fun getAllShuttlePassFilteredBySync(driverId: String) : Flow<List<ShuttlePassWithPassengerEntity>> {
        return database.ShuttlePassDao().getAllShuttlePassFilteredBySync(driverId)
    }

    override fun getAllShuttlePassFilteredByLate(driverId: String) : Flow<List<ShuttlePassWithPassengerEntity>> {
        return database.ShuttlePassDao().getAllShuttlePassFilteredByLate(driverId)
    }

    override fun countUnsyncedShuttlePass(accountId: String): Flow<Int> {
        return database.ShuttlePassDao().countUnsyncedShuttlePass(accountId)
    }

    override fun countLateShuttle(accountId: String): Flow<Int> {
        return database.ShuttlePassDao().countLateShuttle(accountId)
    }

    override fun getShuttlePassWithPassengerById(id: String) : Flow<ShuttlePassWithPassengerEntity> {

        return database.ShuttlePassDao().getShuttlePassWithPassengerById(id)
    }

    override fun getShuttlePassById(id: String) : Flow<ShuttlePassEntity> {
        return database.ShuttlePassDao().getShuttlePassById(id)
    }

    override suspend fun getShuttlePassIdDraftByDriverId(driverId: String) : String? {
        return database.ShuttlePassDao().getShuttlePassIdDraftByDriverId(driverId)
    }

    override fun getDraftShuttlePass(driverId: String) : Flow<ShuttlePassEntity?> {
        return database.ShuttlePassDao().getDraftedShuttlePass(driverId)
    }

    override suspend fun postShuttlePassWithPassenger(
        shuttlePassWithPassengerDto: List<ShuttlePassWithPassengerDto>)
            : Resource<ShuttlePassWithPassengerResponseBodyDto>
    {
        return try {
            val response = api.postShuttlePassWithPassenger(shuttlePassWithPassengerDto)
            val body = response.body()
            if (response.isSuccessful) {
                Resource.Success(data = body)
            } else {
                Resource.Error("Failed. Status code: ${response.message()}")
            }
        }  catch (ex: SocketTimeoutException) {
            Resource.Error("There is something a problem. The server may be offline or experiencing downtime. Please try again later.")
        } catch (ex: ConnectException) {
            Resource.Error("Cannot connect to network. Please check your internet connection and try again later.")
        } catch (ex: Exception) {
            Resource.Error("Exception: ${ex.localizedMessage ?: "Internal server error.Please try again later."}")
        }
    }


}