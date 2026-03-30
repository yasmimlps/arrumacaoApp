package com.example.arrumacao.data.repository

import com.example.arrumacao.domain.model.DashboardData
import com.example.arrumacao.domain.model.ExpenseCategory
import com.example.arrumacao.domain.repository.FinanceRepository
import com.example.arrumacao.domain.model.InsightIconType
import com.example.arrumacao.domain.model.MonthlyInsight
import javax.inject.Inject

class FinanceRepositoryImpl @Inject constructor() : FinanceRepository {
    override suspend fun getDashboardData(): DashboardData {
        return DashboardData(
            currentBalance = 14250.00,
            netBalance = 8920.45,
            totalToPay = 3420.00,
            expectedExpense = 5100.00,
            expectedFinalBalance = 10830.00,
            actualExpense = 2890.12,
            savingsPercentage = 0.72f,
            expensesByCategory = listOf(
                ExpenseCategory("Moradia", 0.45f, 1260.0, "#A8E6CF"),
                ExpenseCategory("Lazer", 0.30f, 840.0, "#81D4FA"),
                ExpenseCategory("Outros", 0.25f, 700.0, "#D1C4E9")
            ),
            monthlyInsights = listOf(
                MonthlyInsight(
                    "Economia em Lazer",
                    "Você gastou 15% menos...",
                    InsightIconType.SAVINGS
                ),
                MonthlyInsight(
                    "Meta de Moradia",
                    "Gastos fixos dentro do planejado.",
                    InsightIconType.TARGET
                )
            )
        )
    }
}