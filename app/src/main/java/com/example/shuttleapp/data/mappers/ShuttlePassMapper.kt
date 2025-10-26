package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.ShuttlePassEntity
import com.example.shuttleapp.data.network.response.ShuttlePassDto
import com.example.shuttleapp.domain.model.ShuttlePass

fun ShuttlePassEntity.toDto() : ShuttlePassDto {

    return ShuttlePassDto(
        arrivaltime = arrival,
        datecreated = date,
        departuretime = departure,
        driverid = driver,
        islateshuttle = isLateShuttle
    )
}

//fun ShuttlePassEntity.toShuttlePass() : ShuttlePass {
//
//    return ShuttlePass(
//        id = TODO(),
//        route = TODO(),
//        provider = TODO(),
//        driver = TODO(),
//        plateNumber = TODO(),
//        date = TODO(),
//        dateCreated = TODO(),
//        tripType = TODO(),
//        departure = TODO(),
//        arrival = TODO(),
//        isSynced = TODO(),
//        isLateShuttle = TODO(),
//        isDraft = TODO()
//    )
//}