//package com.example.shuttle.shuttlepassmodule.presentation.viewmodel
//
//import android.util.Log
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.shuttle.shuttlepassmodule.data.model.Passenger
//import com.example.shuttle.shuttlepassmodule.di.Graph
//import com.example.shuttle.shuttlepassmodule.domain.model.ManualInputValidationResult
//import com.example.shuttle.shuttlepassmodule.domain.repository.ShuttleRepository
//import com.example.shuttle.shuttlepassmodule.domain.usecase.manualaddpassenger.ValidateQRCodeInput
//import com.example.shuttle.presentation.state.ShuttlePassInputState
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//
//class PassengerViewModel(
//    private val shuttleRepository: ShuttleRepository = Graph.repository
//) : ViewModel() {
//
//
//    private val validateEmpNumInput: ValidateQRCodeInput = ValidateQRCodeInput()
//
//    var passengerState by mutableStateOf(ShuttlePassInputState())
//        private set
//
//    fun onEmployeeNumChange(newValue: String) {
//        passengerState = passengerState.copy(employeeNumber = newValue)
//
//        checkInputValidation()
//    }
//
//    fun onNameChange(newValue: String) {
//        passengerState = passengerState.copy(name = newValue)
//
//        checkInputValidation()
//    }
//
//    fun onDeptChange(newValue: String) {
//        passengerState = passengerState.copy(employeeNumber = newValue)
//
//        checkInputValidation()
//    }
//
//
//    fun onAddClicked() {
//
//    }
//
//    fun loadPassenger(id: Long) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                getPassengerById(id).collectLatest{ passenger ->
//                    passengerState = passengerState
//                }
//            }
//            catch (ex: Exception) {
//                Log.e("Error", "An error occurred. Please try again. ${ex.message}")
//            }
//
//        }
//    }
//
//    fun insertPassenger(passenger: Passenger) {
//        viewModelScope.launch(Dispatchers.IO) {
//            shuttleRepository.insertPassenger(passenger)
//        }
//    }
//
//    fun deletePassenger(passenger: Passenger) {
//        viewModelScope.launch(Dispatchers.IO) {
//            shuttleRepository.deletePassenger(passenger)
//        }
//    }
//
//    fun getDraftedPassenger() : Flow<List<Passenger>> {
//        return shuttleRepository.getDraftedPassengers()
//    }
//
//
//    fun getPassengerById(id: Long) : Flow<Passenger> {
//        return shuttleRepository.getPassengerById(id)
//
//    }
//
//
//    private fun checkInputValidation() {
//        val validationResult = validateManualInput(
//            passengerState.data.employeeNumber,
//            passengerState.data.name,
//            passengerState.data.department
//        )
//        processManualInputValidationType(validationResult)
//    }
//
//    protected fun processManualInputValidationType(type: ManualInputValidationResult) {
//
//        passengerState = when(type) {
//            ManualInputValidationResult.EmptyFields ->{
//                passengerState.copy(errorMessage = "All fields are required.", isValid = false)
//            }
//            ManualInputValidationResult.NumbersOnly -> {
//                passengerState.copy(errorMessage = "Employee number should contain numbers only", isValid = false)
//            }
//            ManualInputValidationResult.InvalidName -> {
//                passengerState.copy(errorMessage = "Invalid Passenger Name", isValid = false)
//            }
//            ManualInputValidationResult.Valid -> {
//                passengerState.copy(errorMessage = null, isValid = true)
//            }
//            //ManualInputValidationResult.DepartmentNotExist -> TODO()
//        }
//    }
//}