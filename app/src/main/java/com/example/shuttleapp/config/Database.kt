package com.example.shuttleapp.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shuttleapp.data.local.RememberedUserEntity
import com.example.shuttleapp.data.local.RoleEntity
import com.example.shuttleapp.data.local.ShuttleEntity
import com.example.shuttleapp.data.local.ShuttleProviderEntity
import com.example.shuttleapp.data.local.UserDataEntity
import com.example.shuttleapp.data.local.dao.RememberedUserDao
import com.example.shuttleapp.data.local.dao.ShuttleDao
import com.example.shuttleapp.data.local.dao.ShuttleProviderDao
import com.example.shuttleapp.data.local.dao.UserDataDao
import com.example.shuttleapp.data.local.dao.PassengerQRDao
import com.example.shuttleapp.data.local.dao.RoutesDao
import com.example.shuttleapp.data.local.dao.ShuttlePassDao
import com.example.shuttleapp.data.local.ShuttlePassEntity
import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.data.local.RouteEntity

@Database(
    entities = [
        ShuttlePassEntity::class,
        PassengerQREntity::class,
        RoleEntity::class,
        UserDataEntity::class,
        RouteEntity::class,
        ShuttleEntity::class,
        ShuttleProviderEntity::class,
        RememberedUserEntity::class
    ],
    version = 26,
    exportSchema = false,

    )
abstract class ShuttleDatabase : RoomDatabase() {

    //    init the DAO's
    abstract fun ShuttlePassDao() : ShuttlePassDao
    abstract fun PassengerQRDao() : PassengerQRDao
    abstract fun RoutesDao() : RoutesDao
    abstract fun UserDataDao() : UserDataDao
    abstract fun ShuttleDao() : ShuttleDao
    abstract fun ShuttleProviderDao() : ShuttleProviderDao
    abstract fun RememberedUserDao() : RememberedUserDao


}