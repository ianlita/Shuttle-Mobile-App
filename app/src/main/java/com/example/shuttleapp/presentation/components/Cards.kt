package com.example.shuttleapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentLate
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.SyncProblem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.shuttleapp.ui.theme.AppleGreen
import com.example.shuttleapp.ui.theme.Lavender
import com.example.shuttleapp.ui.theme.Orange
import com.example.shuttleapp.ui.theme.PowderBlue
import com.example.shuttleapp.ui.theme.SurfaceBg

// Example color tokens — replace with your app tokens


@Composable
fun CardsContainer(
    lateShuttleCount: Int,
    unsyncedShuttleCount: Int,
    passengerCount: Int,
    currentRoute: String,
    tripType: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Top row: two square cards side-by-side
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Each takes half width and keeps square shape using aspectRatio(1f)
            SmallStatCard(
                modifier = Modifier.weight(1f),
                title = "Total Late Pass",
                value = "$lateShuttleCount",
                subtitle = "You have $lateShuttleCount late shuttle recorded",
                color = Orange,
                icon = Icons.Filled.AssignmentLate
            )

            SmallStatCard(
                modifier = Modifier.weight(1f),
                title = "Total Unsynced Pass",
                value = "$unsyncedShuttleCount",
                subtitle = if (unsyncedShuttleCount == 0) "All shuttle pass are synced to server"
                else "Sync your completed shuttle pass immediately",
                color = Lavender,
                icon = Icons.Filled.SyncProblem
            )
        }

        // Bottom: two full-width rectangular cards stacked
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            FullWidthCard(
                title = "Current Route",
                value = if (currentRoute.isBlank()) "No Trip" else "$currentRoute - $tripType",
                subtitle = if (currentRoute.isBlank()) "There is no active trip right now"
                else "$tripType trip via $currentRoute Route",
                color = PowderBlue,
                icon = Icons.Filled.Route
            )

            FullWidthCard(
                title = "Current Passenger Count",
                value = "$passengerCount",
                subtitle = if (passengerCount == 0) "Create new shuttle pass to record passengers count"
                else "There are currently $passengerCount passengers onboard! Have a safe trip",
                color = AppleGreen,
                icon = Icons.Filled.Group
            )
        }
    }
}

@Composable
private fun SmallStatCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtitle: String,
    color: Color,
    icon: ImageVector
) {
    Card(
        modifier = modifier
            .aspectRatio(1.3f) // determines height, 1f - keeps the card square
            .clip(RoundedCornerShape(14.dp)),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header
            Text(
                text = title.uppercase(),
                color = Color.White.copy(alpha = 0.95f),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )

            // Middle: icon + big number centered
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = value,
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Footer
            Text(
                text = subtitle,
                color = Color.White.copy(alpha = 0.95f),
                fontSize = 12.sp,
                lineHeight = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun FullWidthCard(
    title: String,
    value: String,
    subtitle: String,
    color: Color,
    icon: ImageVector
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(14.dp)),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(color, color.copy(alpha = 0.92f))
                    )
                )
                .padding(horizontal = 14.dp, vertical = 8.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Header row: title and optional action/icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title.uppercase(),
                        color = Color.White.copy(alpha = 0.95f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    // small icon at header (decorative)
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Big info row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = value,
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle wraps and drives card height
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.95f),
                    fontSize = 12.sp,
                    lineHeight = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F1720)
@Composable
fun CardsContainerPreview() {
    Surface(modifier = Modifier.fillMaxSize(), color = SurfaceBg) {
        CardsContainer(
            lateShuttleCount = 3,
            unsyncedShuttleCount = 1,
            passengerCount = 24,
            currentRoute = "Downtown Loop",
            tripType = "Express"
        )
    }
}
