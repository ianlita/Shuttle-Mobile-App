package com.example.shuttleapp.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class ShuttlePassWithPassengerEntity(

    @Embedded val shuttlePass: ShuttlePassEntity, //the embedded is the instance that contains a multiple instance

    @Relation(
        parentColumn = "id", //from shuttle pass column
        entityColumn = "shuttlePassId") //from the passenger column
    val passengersQR: List<PassengerQREntity>
)