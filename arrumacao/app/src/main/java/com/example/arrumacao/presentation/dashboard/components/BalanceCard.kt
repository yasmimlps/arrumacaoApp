package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.arrumacao.core.util.coloredShadow
import com.example.arrumacao.core.util.toBRL
import com.example.arrumacao.presentation.theme.AppLetterSpacing
import com.example.arrumacao.presentation.theme.DarkTextGreen
import com.example.arrumacao.presentation.theme.GradientEnd
import com.example.arrumacao.presentation.theme.GradientMiddle
import com.example.arrumacao.presentation.theme.GradientStart
import com.example.arrumacao.presentation.theme.spacing
import com.example.arrumacao.presentation.theme.iconSize

@Composable
fun BalanceCard(
    currentBalance: Double,
    netBalance: Double,
    onTendencyClick: () -> Unit
) {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(GradientStart, GradientMiddle, GradientEnd),
        start = Offset(0f, 0f),
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .coloredShadow(
                color = DarkTextGreen,
                alpha = 0.08f,
                blurRadius = MaterialTheme.spacing.extraLarge,
                borderRadius = MaterialTheme.spacing.large
            )
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier
                    .background(brush = gradientBrush)
                    .padding(MaterialTheme.spacing.large)
            ) {
                Text(
                    text = "SALDO ATUAL",
                    style = MaterialTheme.typography.labelMedium,
                    letterSpacing = AppLetterSpacing.Wide,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))

                Text(
                    text = currentBalance.toBRL(),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,

                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.3f),
                    thickness = MaterialTheme.spacing.default
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "SALDO LÍQUIDO",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )

                        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))

                        Text(
                            text = netBalance.toBRL(),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    IconButton(
                        onClick = onTendencyClick,
                        modifier = Modifier
                            .size(MaterialTheme.iconSize.extraLarge)
                            .clip(MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.surface)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ShowChart,
                            contentDescription = "Tendência",
                            tint = DarkTextGreen,
                            modifier = Modifier.size(MaterialTheme.iconSize.medium)
                        )
                    }
                }
            }
        }
    }
}