package com.futsalmanager.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class FutsalScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object MatchEngine : FutsalScreen("match_engine", "Jogo", Icons.Default.PlayArrow)
    object Tactics : FutsalScreen("tactics", "Táticas", Icons.Default.Menu)
    object Finance : FutsalScreen("finance", "Finanças", Icons.Default.CheckCircle)
    object Training : FutsalScreen("training", "Treinos", Icons.Default.AccountCircle)
    object Market : FutsalScreen("market", "Mercado", Icons.Default.ShoppingCart)

    companion object {
        val items = listOf(MatchEngine, Tactics, Finance, Training, Market)
    }
}
