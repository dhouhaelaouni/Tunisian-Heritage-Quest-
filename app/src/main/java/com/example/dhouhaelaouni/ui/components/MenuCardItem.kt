package com.example.dhouhaelaouni.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MenuCard(
    val emoji: String,
    val title: String,
    val subtitle: String,
    val highlighted: Boolean = false
)

@Composable
fun MenuCardItem(card: MenuCard, onClick: () -> Unit) {
    val NavyText   = Color(0xFF2C2C2A)
    val MedBlue    = Color(0xFF4A7FB5)
    val BluLight   = Color(0xFFEEF3FB)
    val BluBorder  = Color(0xFFB5D4F4)
    val GrayMid    = Color(0xFF888780)
    val GrayLight  = Color(0xFFE8E4DC)
    val CardWhite  = Color(0xFFFFFFFF)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (card.highlighted) BluLight else CardWhite,
                RoundedCornerShape(13.dp)
            )
            .border(
                1.5.dp,
                if (card.highlighted) BluBorder else GrayLight,
                RoundedCornerShape(13.dp)
            )
            .clickable { onClick() }
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(card.emoji, fontSize = 22.sp)
        Text(card.title, fontSize = 12.sp,
            fontWeight = FontWeight.Medium, color = NavyText)
        Text(card.subtitle, fontSize = 10.sp, color = GrayMid)
        Text(
            "→", fontSize = 11.sp,
            color = if (card.highlighted) MedBlue else GrayLight,
            modifier = Modifier.align(Alignment.End)
        )
    }
}
