package com.example.shuttleapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.shuttleapp.data.local.ShuttleProviderEntity

@Dao
interface ShuttleProviderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShuttleProvider(shuttleProviderEntity: ShuttleProviderEntity)

    @Transaction
    @Query("SELECT * FROM shuttleProvider WHERE shuttleProviderId = :id")
    suspend fun getShuttleProviderById(id: String) : ShuttleProviderEntity

    @Transaction
    @Query("SELECT providerName FROM shuttleProvider WHERE shuttleProviderId = :providerId")
    suspend fun getProviderNameById(providerId: String) : String?
}