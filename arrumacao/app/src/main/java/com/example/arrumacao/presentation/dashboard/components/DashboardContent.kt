package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arrumacao.domain.model.DashboardData
import com.example.arrumacao.presentation.theme.*

@Composable
fun DashboardContent(data: DashboardData) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            DashboardHeader(userName = "Novembro", currentMonth = "Novembro")

            Column(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)) {

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                BalanceCard(
                    currentBalance = data.currentBalance,
                    netBalance = data.netBalance,
                    onTendencyClick = {}
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
                ) {
                    SummaryCard(
                        title = "TOTAL A PAGAR",
                        value = 3420.00,
                        icon = Icons.Default.AttachMoney,
                        iconColor = DarkTextGreen,
                        modifier = Modifier.weight(1f)
                    )
                    SummaryCard(
                        title = "GASTO PREVISTO",
                        value = 5100.00,
                        icon = Icons.Default.CalendarToday,
                        iconColor = DarkTextGreen,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                PredictedFinalBalanceCard(value = 10830.00)

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                SavingsAndRealSpendRow(realSpend = 2890.12, savingsLabel = "72%", progress = 0.72f)

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

                Text(
                    text = "Gastos por Categoria",
                    style = MaterialTheme.typography.titleLarge,
                    color = DarkTextGreen,
                    modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.doubleLarge)) // Respiro final para o FAB
            }
        }
    }
}


@Composable
fun PredictedFinalBalanceCard(value: Double) {
    Surface(
        modifier = Modifier.fillMaxWidth().shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        color = HighlightBlue
    ) {
        Row(
            modifier = Modifier.padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.Wallet, contentDescription = null, tint = AccentGreen)
            }
            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = "SALDO PREVISTO FINAL", style = MaterialTheme.typography.labelSmall, color = AccentGreen)
                Text(
                    text = "R$ ${"%.2f".format(value)}",
                    style = MaterialTheme.typography.titleMedium,
                    color = DarkTextGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, tint = AccentGreen)
        }
    }
}

@Composable
fun SavingsAndRealSpendRow(realSpend: Double, savingsLabel: String, progress: Float) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
    ) {
        SummaryCard(
            title = "GASTO REAL",
            value = realSpend,
            icon = Icons.Default.MonetizationOn,
            iconColor = DarkTextGreen,
            modifier = Modifier.weight(1f)
        )
        SavingsCard(
            progress = 0.72f,
            savingsLabel = "72%",
            modifier = Modifier.weight(1f)
        )
    }
}