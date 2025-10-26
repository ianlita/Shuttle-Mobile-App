package com.example.shuttleapp.data.local.dao

//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import androidx.room.Transaction
//import com.example.shuttleapp.data.local.RoleEntity
//
//interface RoleDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertRoles(roles: List<RoleEntity>)
//
//    @Transaction
//    @Query("SELECT * FROM users")
//    suspend fun getAllRoles(): List<RoleEntity>
//
//    @Transaction
//    @Query("SELECT * FROM users WHERE accountId = :id")
//    suspend fun getRoleById(id: String): RoleEntity
//
//    @Transaction
//    @Query("DELETE FROM users")
//    suspend fun deleteAllRoles()
//}