package com.futsalmanager.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.futsalmanager.navigation.FutsalScreen
import com.futsalmanager.ui.match.MatchEngineScreen
import com.futsalmanager.ui.scouting.TransferMarketScreen
import com.futsalmanager.ui.tactics.TacticsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        containerColor = Color(0xFF0F172A),
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF1E293B), tonalElevation = 8.dp) {
                FutsalScreen.items.forEach { screen ->
                    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title, fontSize = 10.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color(0xFF1E88E5),
                            indicatorColor = Color(0xFF1E88E5),
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = FutsalScreen.MatchEngine.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(FutsalScreen.MatchEngine.route) { MatchEngineScreen() }
            composable(FutsalScreen.Tactics.route) { TacticsScreen() }
            composable(FutsalScreen.Finance.route) { Text("Ecrã Finanças", color = Color.White) }
            composable(FutsalScreen.Training.route) { Text("Ecrã Treinos", color = Color.White) }
            composable(FutsalScreen.Market.route) { TransferMarketScreen() }
        }
    }
}
