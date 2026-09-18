package com.futsalmanager.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class FutsalScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object MatchEngine : FutsalScreen("match_engine", "Jogo", Icons.Default.SportsSoccer)
    object Tactics : FutsalScreen("tactics", "Táticas", Icons.Default.GridView)
    object Finance : FutsalScreen("finance", "Finanças", Icons.Default.AttachMoney)
    object Training : FutsalScreen("training", "Treinos", Icons.Default.FitnessCenter)
    object Market : FutsalScreen("market", "Mercado", Icons.Default.ShoppingCart)

    companion object {
        val items = listOf(MatchEngine, Tactics, Finance, Training, Market)
    }
}
