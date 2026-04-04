package com.example.arrumacao.presentation.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.arrumacao.core.util.toBRL
import com.example.arrumacao.domain.model.DashboardData
import com.example.arrumacao.presentation.dashboard.DashboardEvent
import com.example.arrumacao.presentation.theme.*

@Composable
fun DashboardContent(data: DashboardData, onEvent: (DashboardEvent) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
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
                    onTendencyClick = {onEvent(DashboardEvent.OnTendencyClicked)}
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
                ) {
                    SummaryCard(
                        title = "TOTAL A PAGAR",
                        value = data.totalToPay,
                        icon = Icons.Default.Money,
                        iconColor = IconPurple,
                        modifier = Modifier.weight(1f)
                    )
                    SummaryCard(
                        title = "GASTO PREVISTO",
                        value = data.expectedExpense,
                        icon = Icons.Default.CalendarMonth,
                        iconColor = IconGreen,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                PredictedFinalBalanceCard(value = data.expectedFinalBalance, onClick = {onEvent(DashboardEvent.OnAddTransactionClicked)})

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                SavingsAndRealSpendRow(realSpend = data.actualExpense, savingsLabel = "72%", progress = 0.72f)

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

                ExpenseByCategoryCard(
                    modifier = Modifier.fillMaxWidth(),
                    totalGastoLabel = data.totalToPay,
                    moradiaPercentage = 0.45f,
                    lazerPercentage = 0.30f,
                    outrosPercentage = 0.25f
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.doubleLarge))
            }
        }
    }
}

@Composable
fun PredictedFinalBalanceCard(
    value: Double,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = MaterialTheme.shapes.large,
        color = HighlightBlue,
        border = BorderStroke(
            width = MaterialTheme.borderWidth.thin,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.09f)
        )
        ) {
        Row(
            modifier = Modifier.padding(MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(MaterialTheme.iconSize.extraLarge)
                    .clip(MaterialTheme.shapes.large)
                    .background(IconTendencyBlue)
                    .padding(MaterialTheme.spacing.small),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Wallet,
                    contentDescription = null,
                    tint = IconBlue,
                    modifier = Modifier.size(MaterialTheme.iconSize.medium)
                )
            }

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.medium))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "SALDO PREVISTO FINAL",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Text(
                    text = value.toBRL(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Ver detalhes",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun SavingsAndRealSpendRow(
    realSpend: Double,
    savingsLabel: String,
    progress: Float
) {
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
            progress = progress,
            savingsLabel = savingsLabel,
            modifier = Modifier.weight(1f)
        )
    }
}