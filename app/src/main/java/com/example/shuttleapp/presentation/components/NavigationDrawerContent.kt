package com.example.shuttleapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shuttleapp.R
import com.example.shuttleapp.domain.model.UserData
import com.example.shuttleapp.ui.theme.NavyBlue
import com.example.shuttleapp.ui.theme.White
//NavigationDrawerContent
@Composable
fun DrawerContent(onLogOut: () -> Unit = {}, userData: UserData, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(color = NavyBlue).fillMaxWidth().height(150.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.shuttle_vector),
                tint = White,
                contentDescription = "Shuttle",
                modifier = Modifier.size(90.dp)
            )

            Text(
                text = "Shuttle Mobile App",
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
        }
        HorizontalDivider()

        NavigationDrawerItem(
            label = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${userData.firstName.uppercase()} ${userData.lastName.uppercase()}",
                        color = Color.Black,
                        fontSize = 16.sp
                    )

                    if (userData.empNo.isNotBlank()) {
                        Text(
                            text = userData.empNo,
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }

            },
            onClick = {

            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    tint = NavyBlue,
                    contentDescription = "profile",
                    modifier = Modifier.size(46.dp)
                )
            },
            selected = false,
        )

        Spacer(Modifier.weight(.95f))

        HorizontalDivider()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(NavyBlue),
                elevation = ButtonDefaults.buttonElevation(4.dp),
                onClick = { onLogOut() })
            {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.Logout,
                    tint = White,
                    contentDescription = "Log out",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Logout",
                    color = White,
                    fontSize = 14.sp
                )
            }
            Spacer(Modifier.weight(.05f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevTest() {

    DrawerContent(
        {}, UserData(
            accountId = "asda2a22225",
            empNo = "1245151222",
            firstName = "kooabwegabw",
            lastName = "Kabawaw",
            middleName = "anwyauya",
            providerId = "awfaw"
        ),
        navController = rememberNavController()
    )
}


