package com.example.arrumacao.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arrumacao.core.dispatchers.AppDispatchers
import com.example.arrumacao.domain.repository.FinanceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: FinanceRepository,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardState>(DashboardState.Loading)
    val uiState: StateFlow<DashboardState> = _uiState.asStateFlow()

    init {
        onEvent(DashboardEvent.OnRefresh)
    }

    fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.OnRefresh -> loadDashboardData()
            is DashboardEvent.OnAddTransactionClicked -> { /* TODO */ }
            is DashboardEvent.OnDeleteTransaction -> { /* TODO */ }
            is DashboardEvent.OnTendencyClicked -> { /* TODO */ }
        }
    }

    private fun loadDashboardData() {
        viewModelScope.launch((dispatchers.io)) {
            _uiState.value = DashboardState.Loading
            try {
                val data = repository.getDashboardData()
                _uiState.value = DashboardState.Success(data)
            } catch (e: Exception) {
                _uiState.value = DashboardState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}