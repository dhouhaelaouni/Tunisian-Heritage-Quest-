package com.example.dhouhaelaouni.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreDisplay(score: Int) {
    val NavyText   = Color(0xFF2C2C2A)
    val Gold       = Color(0xFFB8860B)
    val GrayLight  = Color(0xFFE8E4DC)

    Box(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(99.dp))
            .border(1.5.dp, GrayLight, RoundedCornerShape(99.dp))
            .padding(horizontal = 12.dp, vertical = 5.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
            Text("Score: ", fontSize = 12.sp, color = NavyText,
                fontWeight = FontWeight.Normal)
            Text("$score", fontSize = 12.sp,
                color = Gold, fontWeight = FontWeight.Medium)
        }
    }
}
