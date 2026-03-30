package com.example.arrumacao.presentation.dashboard

import com.example.arrumacao.domain.model.DashboardData

sealed class DashboardState {
    object Loading : DashboardState()
    data class Success(val data: DashboardData) : DashboardState()
    data class Error(val message: String) : DashboardState()
}