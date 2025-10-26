package com.example.shuttleapp.data.mappers


import com.example.shuttleapp.data.local.ShuttlePassEntity
import com.example.shuttleapp.data.local.ShuttlePassWithPassengerEntity
import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerDto
import com.example.shuttleapp.domain.model.ShuttlePassWithPassenger


fun ShuttlePassWithPassenger.toDto() : ShuttlePassWithPassengerDto {

    return ShuttlePassWithPassengerDto(
        id = shuttlePass.id,
        driverId = shuttlePass.driver,
        shuttleId = shuttlePass.plateNumber,
        routeId = shuttlePass.route,
        dateCreated = shuttlePass.date,
        tripType = shuttlePass.tripType,
        arrivalTime = shuttlePass.arrival,
        departureTime = shuttlePass.departure,
        isLateShuttle = shuttlePass.isLateShuttle,
        passengers = passengersQR.map { it.toDto() }

    )
}

fun ShuttlePassWithPassengerEntity.toDto() : ShuttlePassWithPassengerDto {

    return ShuttlePassWithPassengerDto(
        id = shuttlePass.id,
        shuttleId = shuttlePass.plateNumber,
        routeId = shuttlePass.routeId,
        tripType = shuttlePass.tripType,
        arrivalTime = shuttlePass.arrival,
        dateCreated = shuttlePass.date,
        departureTime = shuttlePass.departure,
        driverId = shuttlePass.driver,
        isLateShuttle = shuttlePass.isLateShuttle,
        passengers = passengersQR.map { it.toDto() }

    )
}