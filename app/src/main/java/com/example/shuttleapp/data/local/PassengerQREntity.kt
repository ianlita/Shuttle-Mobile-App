package com.example.shuttleapp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "passengerQR",
    foreignKeys = [
        ForeignKey(
            entity = ShuttlePassEntity::class,
            parentColumns = ["id"],
            childColumns = ["shuttlePassId"],
            onDelete = ForeignKey.CASCADE)
    ],//deletes passengers if shuttlepass is deleted
    indices = [
        Index(value = ["shuttlePassId"]),
        Index(value = ["shuttlePassId","scannedQR"], unique = true)
    ]
)
data class PassengerQREntity(

    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),
    var shuttlePassId: String = "",
    var scannedQR: String = "",
    var timeIn: String = "",
    var isDraft: Boolean = true
)
//data class Passenger(
//    @PrimaryKey
//    var id: String = UUID.randomUUID().toString(),
//    var shuttlePassId: String = "",
//    var employeeNumber: String = "",
//    var name: String = "",
//    var department: String = "",
//    var timeIn: String = "",
//    var isDraft : Boolean = true
//
//)
