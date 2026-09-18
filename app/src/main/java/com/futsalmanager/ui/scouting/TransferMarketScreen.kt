package com.futsalmanager.ui.scouting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class FutsalPosition(val shortCode: String) {
    ALL("TODOS"), GOALKEEPER("GR"), FIXO("FIX"), ALA("ALA"), PIVO("PIV")
}

@Composable
fun TransferMarketScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(16.dp)
    ) {
        Text("Mercado & Scouting", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Zicky Té (PIV) - Sporting CP", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Valor: 380.000 €", color = Color(0xFF4CAF50), fontSize = 12.sp)
            }
        }
    }
}
