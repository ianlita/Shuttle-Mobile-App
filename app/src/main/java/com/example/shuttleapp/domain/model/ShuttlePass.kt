package com.example.shuttleapp.domain.model

import java.util.UUID

data class ShuttlePass(
    var id: String = UUID.randomUUID().toString(),

    var route: String = "",
    var provider: String = "",
    var driver: String = "",
    var plateNumber: String = "",
    var date: String = "",
    var dateCreated: String = "",
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