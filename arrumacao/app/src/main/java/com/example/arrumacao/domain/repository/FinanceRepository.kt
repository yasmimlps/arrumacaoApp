package com.example.arrumacao.domain.repository

import com.example.arrumacao.domain.model.DashboardData

interface FinanceRepository {
    suspend fun getDashboardData(): DashboardData
}