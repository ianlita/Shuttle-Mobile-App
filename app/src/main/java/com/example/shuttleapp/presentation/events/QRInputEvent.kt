package com.example.shuttleapp.presentation.events

sealed class QRInputEvent {

    data class ScannedQRChanged(val scannedQR : String) : QRInputEvent()

    data object Submit : QRInputEvent()
}

