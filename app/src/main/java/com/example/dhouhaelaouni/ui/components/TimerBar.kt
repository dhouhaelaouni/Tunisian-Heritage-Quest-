package com.example.dhouhaelaouni.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimerBar(timeLeft: Int, maxTime: Int = 15) {
    val MedBlue    = Color(0xFF4A7FB5)
    val RedDark    = Color(0xFFA32D2D)
    val GrayLight  = Color(0xFFE8E4DC)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .border(2.5.dp, MedBlue, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("$timeLeft", fontSize = 13.sp,
                fontWeight = FontWeight.Medium, color = MedBlue)
        }
        val timerProgress = timeLeft.toFloat() / maxTime.toFloat()
        val animTimer by animateFloatAsState(
            targetValue = timerProgress, animationSpec = tween(900), label = "timer"
        )
        LinearProgressIndicator(
            progress = { animTimer },
            modifier = Modifier.weight(1f).height(4.dp)
                .clip(RoundedCornerShape(99.dp)),
            color = if (timeLeft > 5) MedBlue else RedDark,
            trackColor = GrayLight,
            strokeCap = StrokeCap.Round
        )
    }
}
