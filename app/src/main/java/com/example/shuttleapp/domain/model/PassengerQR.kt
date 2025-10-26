package com.example.shuttleapp.domain.model

import java.util.UUID

data class PassengerQR(

    var id: String = UUID.randomUUID().toString(),
    var shuttlePassId: String = "",
    var scannedQR: String = "",
    var timeIn: String = "",
    var isDraft: Boolean = true
)