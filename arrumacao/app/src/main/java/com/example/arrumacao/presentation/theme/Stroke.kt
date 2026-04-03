package com.example.arrumacao.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class BorderWidth(
    val none: Dp = 0.dp,
    val thin: Dp = 1.dp,
    val medium: Dp = 2.dp,
    val thick: Dp = 4.dp
)

val LocalBorderWidth = compositionLocalOf { BorderWidth() }

val MaterialTheme.borderWidth: BorderWidth
    @Composable
    @ReadOnlyComposable
    get() = LocalBorderWidth.current