package com.example.shuttleapp.presentation.state

data class ScannedQRListState(
    var isLoading: Boolean = false,
    val scannedQRList: List<String> = emptyList()
)
