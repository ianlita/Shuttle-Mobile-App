package com.example.shuttleapp.domain.repository

import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.data.local.ShuttlePassEntity
import com.example.shuttleapp.data.local.ShuttlePassWithPassengerEntity
import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerDto
import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerResponseBodyDto
import com.example.shuttleapp.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response



interface ShuttlePassRepository {

    suspend fun insertShuttlePass(shuttlePass: ShuttlePassEntity)

    suspend fun updateShuttlePass(shuttlePass: List<ShuttlePassEntity>)

    suspend fun  deleteShuttlePassById(id:String)

//SHUTTLEWITHPASSENGER

    suspend fun finalizeShuttleDraft(driverId: String, shuttlePass: ShuttlePassEntity, passengers : List<PassengerQREntity>)

    fun getAllShuttlePassWithPassengers(driverId: String) : Flow<List<ShuttlePassWithPassengerEntity>>

    fun getShuttlePassWithPassengerById(id: String) : Flow<ShuttlePassWithPassengerEntity>

    fun getDraftShuttlePass(driverId: String) : Flow<ShuttlePassEntity?>

    suspend fun getShuttlePassIdDraftByDriverId(driverId: String) : String?

    suspend fun postShuttlePassWithPassenger(shuttlePassWithPassengerDto: List<ShuttlePassWithPassengerDto>
    )  : Resource<ShuttlePassWithPassengerResponseBodyDto>

    fun getAllShuttlePassFilteredBySync(driverId: String): Flow<List<ShuttlePassWithPassengerEntity>>

    fun getAllShuttlePassFilteredByLate(driverId: String): Flow<List<ShuttlePassWithPassengerEntity>>

    fun countUnsyncedShuttlePass(accountId: String) : Flow<Int>

    fun countLateShuttle(accountId: String) : Flow<Int>

    fun getShuttlePassById(id: String): Flow<ShuttlePassEntity>

    suspend fun deleteShuttlePassOnDue(driverId: String) : Int

    suspend fun deleteAllDraftedShuttlePass(accountId: String) : Int

    suspend fun getAllUnsyncedShuttlePasses(driverId: String) : List<ShuttlePassWithPassengerEntity>
}