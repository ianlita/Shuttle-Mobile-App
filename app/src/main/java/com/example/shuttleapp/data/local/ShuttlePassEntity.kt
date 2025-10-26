package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(
    tableName = "shuttle_pass",
    foreignKeys = [
        ForeignKey(
            entity = RouteEntity::class,
            parentColumns = ["routeId"],
            childColumns = ["routeId"]
        ),
        ForeignKey(
            entity = ShuttleEntity::class,
            parentColumns = ["shuttleId"],
            childColumns = ["plateNumber"]
        )
    ],
    indices = [
        Index(value = ["routeId"]),
        Index(value = ["plateNumber"])
    ]
)
data class ShuttlePassEntity(
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),

    var routeId: String = "",
    var provider: String = "",
    var driver: String = "",
    var plateNumber: String = "",
    var date: String = "",
    var dateCreated: Long = System.currentTimeMillis(),
    var tripType: String = "",
    var departure: String = "",
    var arrival: String = "",
    var isSynced: Boolean = false,
    var isLateShuttle: Boolean = false,
    var isDraft: Boolean = true

)


//@Entity("shuttle_pass",
//    foreignKeys = [
//        ForeignKey(entity = Account::class,
//            parentColumns = ["id"],
//            childColumns = ["driverId"],
//            onDelete = ForeignKey.NO_ACTION)],
//    indices = [Index(value = ["driverId"])]
//)
//data class ShuttlePassEntity(
//    @PrimaryKey
//    var id: String = UUID.randomUUID().toString(),
//    var driverId: String = "",
//    var route: String = "",
//    var provider: String = "",
//    var plateNumber: String = "",
//    var date: String = "",
//    var tripType: String = "",
//    var departure: String = "",
//    var arrival: String = "",
//    var isSynced: Boolean = false,
//    var isLateShuttle: Boolean = false,
//    var isDraft: Boolean = true
//
//)
