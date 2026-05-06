package com.example.dhouhaelaouni.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dhouhaelaouni.R
import kotlinx.coroutines.delay

private val DeepBlue = Color(0xFF1A3B5D) // Deep Mediterranean blue
private val Gold     = Color(0xFFD4AF37)
private val Cream    = Color(0xFFF7F3EC)

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    // Automatic transition after 2.5 seconds
    LaunchedEffect(Unit) {
        delay(2500)
        onFinished()
    }

    // Animation for the logo
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "scale"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(DeepBlue, Color(0xFF0C243D))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Hero Icon / Symbol
            Box(
                modifier = Modifier
                    .size(180.dp)
                    .scale(scale)
                    .border(2.dp, Gold.copy(alpha = 0.5f), CircleShape)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }

            Spacer(Modifier.height(32.dp))

            // Title
            Text(
                text = "TUNISIA",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Gold,
                letterSpacing = 8.sp,
                textAlign = TextAlign.Center
            )
            
            Text(
                text = "Heritage Quest",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = Cream,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(Modifier.height(16.dp))

            // Decorative Rule
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .background(Gold)
            )
        }

        // Footer version or loading hint
        Text(
            text = "EXPLORE THE HISTORY",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 48.dp),
            fontSize = 10.sp,
            color = Cream.copy(alpha = 0.5f),
            letterSpacing = 2.sp
        )
    }
}
