package com.example.shuttleapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.shuttleapp.data.local.ShuttleEntity


@Dao
interface ShuttleDao {

    @Transaction
    @Query("SELECT * FROM shuttles")
    suspend fun getAllShuttle() : List<ShuttleEntity>

    @Transaction
    @Query("SELECT * FROM shuttles WHERE shuttleProviderId = :providerId")
    suspend fun getShuttlesByProviderId(providerId: String) : List<ShuttleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShuttle(shuttle: List<ShuttleEntity>)

    @Transaction
    @Query("DELETE from shuttles")
    suspend fun clearAllShuttles()

    @Transaction
    @Query("SELECT shuttleId FROM shuttles WHERE plateNumber = :plateNumber")
    suspend fun getShuttleIdByPlateNumber(plateNumber: String) : String

    @Transaction
    @Query("SELECT plateNumber FROM shuttles WHERE shuttleId = :shuttleId")
    suspend fun getPlateNumberById(shuttleId: String) : String?

}