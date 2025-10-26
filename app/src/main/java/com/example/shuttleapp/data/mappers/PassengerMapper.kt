package com.example.shuttleapp.data.mappers

import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.data.network.response.PassengerDto
import com.example.shuttleapp.domain.model.PassengerQR


fun PassengerQR.toDto() : PassengerDto {

    return PassengerDto(
        id = id,
        shuttlePassId = shuttlePassId,
        scannedQr = scannedQR,
        timeIn = timeIn
    )

}

fun PassengerQREntity.toDto() : PassengerDto {

    return PassengerDto(
        id = id,
        shuttlePassId = shuttlePassId,
        scannedQr = scannedQR,
        timeIn = timeIn
    )
}