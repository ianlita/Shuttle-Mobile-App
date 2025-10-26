package com.example.shuttleapp.domain.model

data class ShuttlePassWithPassenger(

    val shuttlePass: ShuttlePass, //the embedded is the instance that contains a multiple instance
    val passengersQR: List<PassengerQR>
)