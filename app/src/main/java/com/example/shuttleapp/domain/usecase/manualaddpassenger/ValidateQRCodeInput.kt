package com.example.shuttleapp.domain.usecase.manualaddpassenger

import com.example.shuttleapp.data.local.PassengerQREntity
import com.example.shuttleapp.domain.usecase.ShuttlePassValidationResult

class ValidateQRCodeInput() {

    fun execute(qrCode: String, qrCodes: List<PassengerQREntity>) : ShuttlePassValidationResult {


        if(!qrCode.uppercase().contains("SEMPHIL_".uppercase())) { //put !
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Invalid QR Code. Unknown."
            )
        }

        if(qrCodes.any{passenger -> passenger.scannedQR == qrCode}) {
            return ShuttlePassValidationResult(
                successful = false,
                errorMessage = "Employee was already onboarded"
            )
        }

        return ShuttlePassValidationResult(
            successful = true
        )
    }


}