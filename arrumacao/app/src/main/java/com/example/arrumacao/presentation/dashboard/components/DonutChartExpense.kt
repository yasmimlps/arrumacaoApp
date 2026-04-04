package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arrumacao.core.util.toBRL
import com.example.arrumacao.presentation.theme.*

@Composable
fun DonutChartExpense(
    modifier: Modifier = Modifier,
    totalValueLabel: Double,
    segments: List<Pair<Float, Color>>
) {
    Box(
        modifier = modifier.aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 14.dp.toPx()
            val innerRadiusPadding = strokeWidth / 2
            val radius = size.minDimension / 2 - innerRadiusPadding
            val chartSize = Size(radius * 2, radius * 2)
            val chartOffset = Offset(
                (size.width - chartSize.width) / 2,
                (size.height - chartSize.height) / 2
            )

            drawArc(
                color = ChartBackground,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = chartOffset,
                size = chartSize,
                style = Stroke(width = strokeWidth)
            )

            var currentStartAngle = 0f
            segments.forEach { (percentage, color) ->
                val sweepAngle = percentage * 360f
                drawArc(
                    color = color,
                    startAngle = currentStartAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    topLeft = chartOffset,
                    size = chartSize,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
                currentStartAngle += sweepAngle
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "TOTAL",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = totalValueLabel.toBRL(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}