package com.example.shuttleapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.shuttleapp.data.local.UserDataEntity

@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserData(userData: UserDataEntity)

    @Transaction
    @Query("SELECT shuttleProviderId from `UserData` where accountId= :accountId")
    suspend fun getProviderIdByAccountId(accountId: String) : String

    @Transaction
    @Query("SELECT * from UserData WHERE accountId = :accountId")
    suspend fun getUserById(accountId: String) : UserDataEntity

    @Transaction
    @Query("SELECT * from UserData WHERE accountId = :id")
    suspend fun getDriverNameById(id: String) : UserDataEntity?


    @Transaction
    @Query("SELECT * from UserData WHERE firstName = :firstName AND lastName = :lastName")
    suspend fun getUserByName(firstName: String, lastName: String) : UserDataEntity?

    @Transaction
    @Query("DELETE FROM UserData")
    suspend fun clearUserData()

}