package com.example.arrumacao.presentation.dashboard

sealed class DashboardEvent {
    object OnRefresh : DashboardEvent()
    object OnAddTransactionClicked : DashboardEvent()
    object OnTendencyClicked : DashboardEvent()
    data class OnDeleteTransaction(val id: String) : DashboardEvent()
}