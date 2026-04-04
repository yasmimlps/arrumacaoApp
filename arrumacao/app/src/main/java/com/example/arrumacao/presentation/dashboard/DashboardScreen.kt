package com.example.arrumacao.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.arrumacao.presentation.dashboard.components.DashboardContent
import com.example.arrumacao.presentation.theme.BackgroundWhite
import com.example.arrumacao.presentation.theme.elevation
import com.example.arrumacao.presentation.theme.spacing

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
        ) {
            when (val state = uiState) {
                is DashboardState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }

                is DashboardState.Success -> {
                    DashboardContent(data = state.data, onEvent = viewModel::onEvent)
                }

                is DashboardState.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Erro ao carregar dados: ${state.message}",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = { viewModel.onEvent(DashboardEvent.OnAddTransactionClicked) },
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = BackgroundWhite,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = MaterialTheme.elevation.medium,
                pressedElevation = MaterialTheme.elevation.small
            ),
            modifier = Modifier
                .padding(MaterialTheme.spacing.large)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Adicionar nova transação",
                tint = Color.White
            )
        }
    }
}

