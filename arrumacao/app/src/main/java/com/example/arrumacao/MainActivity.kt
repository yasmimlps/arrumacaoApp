package com.example.arrumacao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import com.example.arrumacao.presentation.dashboard.DashboardScreen
import com.example.arrumacao.presentation.theme.ArrumacaoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArrumacaoTheme {
                DashboardScreen()
            }
        }
    }
}