package com.example.shuttleapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shuttleapp.domain.model.UserData
import com.example.shuttleapp.presentation.components.DrawerContent
import com.example.shuttleapp.ui.theme.NavyBlue
import com.example.shuttleapp.ui.theme.White
import java.nio.file.WatchEvent


@Composable
fun CollectorSyncScreen(driverId: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(NavyBlue),
            onClick = {}
        ) {
            Text(
                text = "Generate QR Code",
                color = White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevTest() {

    CollectorSyncScreen(driverId = "124125125612")
}