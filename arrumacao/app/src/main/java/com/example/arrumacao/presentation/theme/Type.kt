package com.example.arrumacao.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(

    labelMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.5.sp,
    )
)

object AppLetterSpacing {
    val Tight = (-0.5).sp
    val Normal = 0.sp
    val Wide = 1.8.sp
    val ExtraWide = 3.sp
}