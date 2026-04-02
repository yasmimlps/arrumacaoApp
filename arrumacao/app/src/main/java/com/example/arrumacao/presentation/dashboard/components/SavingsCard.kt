package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import com.example.arrumacao.presentation.theme.*

@Composable
fun SavingsCard(
    progress: Float,
    savingsLabel: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = MaterialTheme.spacing.extraSmall
    ) {
        Column(
            modifier = Modifier.padding(MaterialTheme.spacing.medium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(MaterialTheme.iconSize.extraLarge)
                        .clip(MaterialTheme.shapes.small)
                        .background(IconGreen.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Savings,
                        contentDescription = "Poupança",
                        tint = DarkTextGreen,
                        modifier = Modifier.size(MaterialTheme.iconSize.medium)
                    )
                }

                Text(
                    text = savingsLabel,
                    style = MaterialTheme.typography.titleMedium,
                    color = DarkTextGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

            Text(
                text = "POUPANÇA",
                style = MaterialTheme.typography.labelSmall,
                color = AccentGreen,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            GradientProgressBar(progress = progress)
        }
    }
}

@Composable
private fun GradientProgressBar(progress: Float) {
    val safeProgress = progress.coerceIn(0f, 1f)
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(IconGreen, IconTendencyBlue)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .clip(CircleShape)
            .background(HighlightBlue.copy(alpha = 0.5f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(safeProgress)
                .fillMaxHeight()
                .clip(CircleShape)
                .background(brush = gradientBrush)
        )
    }
}