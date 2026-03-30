package com.example.arrumacao.domain.model

data class DashboardData(
    val currentBalance: Double,
    val netBalance: Double,
    val totalToPay: Double,
    val expectedExpense: Double,
    val expectedFinalBalance: Double,
    val actualExpense: Double,
    val savingsPercentage: Float,
    val expensesByCategory: List<ExpenseCategory>,
    val monthlyInsights: List<MonthlyInsight>
)