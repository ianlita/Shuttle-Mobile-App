package com.example.shuttleapp.presentation

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shuttleapp.data.local.ShuttlePassEntity
import com.example.shuttleapp.presentation.components.ExpandedDropDown
import com.example.shuttleapp.ui.theme.Black
import com.example.shuttleapp.ui.theme.Gray
import com.example.shuttleapp.ui.theme.NavyBlue
import com.example.shuttleapp.ui.theme.White
import com.example.shuttleapp.presentation.components.TopBarComponent
import com.example.shuttleapp.presentation.events.ShuttlePassInputEvent
import com.example.shuttleapp.presentation.viewmodel.ShuttleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditShuttlePassInformationScreen(id: String, viewModel: ShuttleViewModel, navController: NavController) {

    val context = LocalContext.current
    val routesState by viewModel.routeState.collectAsState() // for routes
    val editedShuttlePass by viewModel.editedShuttlePassState.collectAsState() // to take the value of the specific shuttle to be edit
    val shuttlePassInputState by viewModel.shuttlePassInputState.collectAsState() //for input in shuttle
    val shuttleState by viewModel.shuttleState.collectAsState() //for plate numbers
    val nameState by viewModel.toNameState.collectAsState() // this is for routeId, platenumberId,

    var showTimePickerDialog by remember { mutableStateOf(false) }
    var showDateDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(id) { //this will trigger the moment id will have a value
        if(id != "") {
            try {
                viewModel.loadEditedShuttlePass(id)
            }
            catch (ex: Exception) {
                Log.e("Error", "An error occurred during execution: ${ex.message}")
                ex.printStackTrace()
            }
        }

    }

    LaunchedEffect(editedShuttlePass) {

        //we need to put the initial values to the input event
        try {
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.DriverChanged(editedShuttlePass.driver))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.PlateNumberChanged("${nameState.plateNumber}"))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.RouteChanged("${nameState.routeName}"))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.DateChanged(editedShuttlePass.date))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.TripTypeChanged(editedShuttlePass.tripType))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.ShuttleProviderChanged(editedShuttlePass.provider))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.DepartureChanged(editedShuttlePass.departure))
            viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent.ArrivalChanged(editedShuttlePass.arrival))

        } catch (ex: Exception) {
            Log.e("Error", "Error launchedEffect(editedShuttlePass): ${ex.message}")
            ex.printStackTrace()
        }


    }

    Scaffold(
        modifier = Modifier
            .padding(WindowInsets.ime.asPaddingValues())
            .consumeWindowInsets(WindowInsets.ime),
        topBar = {
            TopBarComponent(
                title = "Edit Information",
                navController = navController
            )
        }

    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding).background(color = White)
                .consumeWindowInsets(innerPadding)
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(Modifier.weight(0.25f))

                Card(modifier = Modifier.border(width = 1.dp, color = Gray, shape = RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(containerColor = White)) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .height(150.dp).fillMaxWidth().padding(16.dp)
                    ) {
                        Text("Date Travel Time", fontSize = 18.sp)

                        Row(modifier = Modifier.padding(start = 16.dp).fillMaxWidth().clickable {
                            //showDateDialog = true
                        }) {
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                tint = Black,
                                contentDescription = "date"
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Date:            ${shuttlePassInputState.date}")
                        }

                        Row(modifier = Modifier.padding(start = 16.dp).fillMaxWidth().clickable {
                            showTimePickerDialog = true
                        }) {
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                tint = Black,
                                contentDescription = "departure"
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Departure: ${shuttlePassInputState.departure}")
                        }

                        Row(modifier = Modifier.padding(start = 16.dp).fillMaxWidth().clickable {
                            //showTimePickerDialog = true
                        }) {
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                tint = Black,
                                contentDescription = "arrival"
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text("Arrival:       ${shuttlePassInputState.arrival}")
                        }

                    }
                }

                Spacer(Modifier.weight(0.25f))

                ExpandedDropDown(
                    label = "Plate Number",
                    categories = shuttleState.plateNumbers,
                    initialValue = shuttlePassInputState.plateNumber,
                    errorIndicator = shuttlePassInputState.plateNumberErrorMessage != null,
                    onValueChanged = {
                        viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent
                            .PlateNumberChanged(it))
                    },
                )

                Spacer(Modifier.height(8.dp))

                ExpandedDropDown(
                    label = "Route",
                    categories = routesState.routes,
                    initialValue = shuttlePassInputState.route,
                    errorIndicator = shuttlePassInputState.routeErrorMessage != null,
                    onValueChanged = {
                        viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent
                            .RouteChanged(it))
                    },
                )

                Spacer(Modifier.height(8.dp))

                ExpandedDropDown(
                    label = "Trip Type",
                    categories = listOf("Incoming","Outgoing"),
                    initialValue = shuttlePassInputState.tripType,
                    errorIndicator = shuttlePassInputState.tripTypeErrorMessage != null,
                    onValueChanged = {
                        viewModel.onShuttlePassInputEvent(ShuttlePassInputEvent
                            .TripTypeChanged(it))
                    },
                )

                Spacer(Modifier.weight(0.25f))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(NavyBlue),
                    onClick = {
                        //TODO edit shuttlepass based on the inputs tas salpak mo sa transaction repo editshuttlepass()

                        //editedShuttlePass... is the value that dont need to be changed

//                           val updateShuttlePass = editedShuttlePass.copy(
//                                routeId = viewModel.getRouteIdByName(shuttlePassInputState.route),
//                                plateNumber = viewModel.getShuttleIdByPlateNumber(shuttlePassInputState.plateNumber),
//                                tripType = shuttlePassInputState.tripType,
//                            )

                        coroutineScope.launch(Dispatchers.IO) {
                            val updatedShuttlePass = listOf(ShuttlePassEntity(
                                id = editedShuttlePass.id,
                                routeId = viewModel.getRouteIdByName(shuttlePassInputState.route),// ?: "routeId", //edit
                                provider = shuttlePassInputState.shuttleProvider,
                                driver = editedShuttlePass.driver,
                                plateNumber = viewModel.getShuttleIdByPlateNumber(shuttlePassInputState.plateNumber), //edit
                                date = editedShuttlePass.date,
                                tripType = shuttlePassInputState.tripType, //edit
                                departure = editedShuttlePass.departure,
                                arrival = editedShuttlePass.arrival,
                                isSynced = editedShuttlePass.isSynced,
                                isLateShuttle = editedShuttlePass.isLateShuttle,
                                isDraft = editedShuttlePass.isDraft
                            ))

                            viewModel.updateShuttlePass(updatedShuttlePass)
                        }
                        navController.navigateUp()
                        Toast.makeText(context, "Successfully saved", Toast.LENGTH_LONG).show()
                    }) {
                    Text("Save")
                }

                Spacer(Modifier.weight(1f))
            }

            if (showTimePickerDialog) {
                InputTimeDialog (onConfirm = {}, onDismiss = { showTimePickerDialog = false })
            }

            if (showDateDialog) {
                InputDateDialog(onDateSelected = {}, onDismiss = {showDateDialog = false} )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTimeDialog(
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit,
) {

    //get current time
    val currentTime = Calendar.getInstance()

    //init time picker state
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    AlertDialog(
        containerColor = White,
        onDismissRequest = onDismiss,
        text = {
            Text("Input Time")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TimeInput(state = timePickerState)
            }
        },
        dismissButton = {
            Box(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .clickable { onDismiss() }
            ) {
                Text("Cancel")
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable {
                        val hour = timePickerState.hour
                        val minutes = timePickerState.minute
                        val timeToString = "$hour : $minutes"
                        onConfirm(timeToString)
                        onDismiss()
                    }
            ) {
                Text("Confirm")
            }

        },
    )


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDateDialog(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit) {

    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }

}