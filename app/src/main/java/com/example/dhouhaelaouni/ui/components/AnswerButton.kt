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

@Composable
fun AnswerButton(
    text: String,
    letter: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    isAnswered: Boolean,
    onClick: () -> Unit
) {
    val Cream      = Color(0xFFF7F3EC)
    val NavyText   = Color(0xFF2C2C2A)
    val GrayMid    = Color(0xFF888780)
    val GrayLight  = Color(0xFFE8E4DC)
    val GreenDark  = Color(0xFF3B6D11)
    val GreenLight = Color(0xFFEAF3DE)
    val GreenText  = Color(0xFF27500A)
    val RedDark    = Color(0xFFA32D2D)
    val RedLight   = Color(0xFFFCEBEB)
    val RedText    = Color(0xFF791F1F)

    val bgColor = when {
        isAnswered && isCorrect           -> GreenLight
        isAnswered && isSelected          -> RedLight
        else                            -> Color.White
    }
    val borderColor = when {
        isAnswered && isCorrect           -> GreenDark
        isAnswered && isSelected          -> RedDark
        else                            -> GrayLight
    }
    val letterBg = when {
        isAnswered && isCorrect           -> GreenDark
        isAnswered && isSelected          -> RedDark
        else                            -> Cream
    }
    val letterColor = when {
        isAnswered && (isCorrect || isSelected) -> Color.White
        else                                  -> GrayMid
    }
    val textColor = when {
        isAnswered && isCorrect           -> GreenText
        isAnswered && isSelected          -> RedText
        else                            -> NavyText
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor, RoundedCornerShape(12.dp))
            .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
            .clickable(enabled = !isAnswered) { onClick() }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(26.dp)
                .background(letterBg, RoundedCornerShape(7.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(letter, fontSize = 11.sp,
                fontWeight = FontWeight.Medium, color = letterColor)
        }
        Text(text, fontSize = 13.sp, color = textColor,
            fontWeight = if (isAnswered && isCorrect) FontWeight.Medium
            else FontWeight.Normal)
    }
}
