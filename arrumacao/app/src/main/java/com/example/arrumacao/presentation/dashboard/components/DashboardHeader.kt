package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arrumacao.presentation.theme.*

@Composable
fun DashboardHeader(userName: String, currentMonth: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(MaterialTheme.spacing.medium),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Perfil",
                tint = AccentGreen,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            Text(
                text = currentMonth,
                style = MaterialTheme.typography.headlineSmall,
                color = DarkTextGreen,
                fontWeight = FontWeight.Bold
            )
        }

        Icon(
            imageVector = Icons.Default.CalendarToday,
            contentDescription = "Calendário",
            tint = AccentGreen,
            modifier = Modifier.size(24.dp)
        )
    }
}