package com.example.arrumacao.presentation.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.arrumacao.domain.model.InsightIconType

fun InsightIconType.toIcon(): ImageVector {
    return when (this) {
        InsightIconType.SAVINGS -> Icons.Default.Savings
        InsightIconType.TARGET -> Icons.Default.AdsClick
        InsightIconType.WARNING -> Icons.Default.Warning
        InsightIconType.CHART -> Icons.AutoMirrored.Filled.ShowChart
    }
}