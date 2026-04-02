package com.example.arrumacao.core.util

import java.text.NumberFormat
import java.util.Locale

fun Double.toBRL(): String {
    val localeBR = Locale("pt", "BR")
    val formatter = NumberFormat.getCurrencyInstance(localeBR)

    return formatter.format(this).trim()
}