package com.example.shuttleapp.presentation.state

sealed class UploadUiState {
    object Idle : UploadUiState()
    object Loading : UploadUiState()
    object Success : UploadUiState()
    object Error : UploadUiState()
}