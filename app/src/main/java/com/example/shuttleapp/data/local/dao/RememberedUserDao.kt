package com.example.shuttleapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.shuttleapp.data.local.RememberedUserEntity

@Dao
interface RememberedUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoggedUser(loggedUserEntity: RememberedUserEntity)

    @Transaction
    @Query("SELECT * FROM loggeduser WHERE isRemembered = 1")
    fun getRememberedUser() : RememberedUserEntity?

    @Transaction
    @Query("SELECT * FROM loggeduser")
    fun getLoggerUser() : RememberedUserEntity?

    @Transaction
    @Query("DELETE FROM loggeduser")
    suspend fun deleteLoggedUser()

}