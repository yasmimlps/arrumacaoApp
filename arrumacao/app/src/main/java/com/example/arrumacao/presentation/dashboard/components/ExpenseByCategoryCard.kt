package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arrumacao.presentation.theme.*

@Composable
fun ExpenseByCategoryCard(
    modifier: Modifier = Modifier,
    totalGastoLabel: Double,
    moradiaPercentage: Float,
    lazerPercentage: Float,
    outrosPercentage: Float
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            width = MaterialTheme.borderWidth.thin,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.09f)
        )
    ) {
        Column(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
            Text(
                text = "Gastos por Categoria",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DonutChartExpense(
                    modifier = Modifier.size(140.dp),
                    totalValueLabel = totalGastoLabel,
                    segments = listOf(
                        moradiaPercentage to ChartMoradia,
                        lazerPercentage to ChartLazer,
                        outrosPercentage to ChartOutros
                    )
                )

                Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
                ) {
                    LegendItem(color = ChartMoradia, name = "Moradia", percentage = moradiaPercentage)
                    LegendItem(color = ChartLazer, name = "Lazer", percentage = lazerPercentage)
                    LegendItem(color = ChartOutros, name = "Outros", percentage = outrosPercentage)
                }
            }
        }
    }
}

@Composable
private fun LegendItem(color: Color, name: String, percentage: Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(MaterialTheme.spacing.medium)
                    .clip(CircleShape)
                    .background(color)
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
        }

        Text(
            text = "${(percentage * 100).toInt()}%",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.SemiBold
        )
    }
}