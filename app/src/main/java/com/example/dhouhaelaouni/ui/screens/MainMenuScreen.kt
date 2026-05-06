package com.example.dhouhaelaouni.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dhouhaelaouni.R
import com.example.dhouhaelaouni.ui.components.MenuCard
import com.example.dhouhaelaouni.ui.components.MenuCardItem

private val Cream      = Color(0xFFF7F3EC)
private val NavyText   = Color(0xFF2C2C2A)
private val MedBlue    = Color(0xFF4A7FB5)
private val Gold       = Color(0xFFB8860B)
private val GrayMid    = Color(0xFF888780)

@Composable
fun MainMenuScreen(
    onStartGame: () -> Unit,
    onByCategory: () -> Unit,
    onSettings: () -> Unit,
    onBack: () -> Unit
) {
    // Handle system back button
    BackHandler {
        onBack()
    }

    val cards = listOf(
        MenuCard("🏛️", "Quick Play",   "Random questions",  highlighted = true),
        MenuCard("🗂️", "By Category",  "Choose a theme"),
        MenuCard("🏆", "Challenge",    "Beat your score"),
        MenuCard("⚙️", "Settings",     "Timer & difficulty")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {
        // ── Hero image ─────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.38f)
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            0.2f to Cream.copy(alpha = 0f),
                            1.0f to Cream
                        )
                    )
            )

            // Back Button Overlay
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp)
                    .background(Color.Black.copy(alpha = 0.3f), CircleShape)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        // ── Body ───────────────────────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.62f)
                .padding(horizontal = 20.dp)
                .padding(bottom = 28.dp)
        ) {
            // Badge
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Box(Modifier.size(5.dp).background(MedBlue, CircleShape))
                Text(
                    "TUNISIA HERITAGE",
                    fontSize = 10.sp, letterSpacing = 2.sp,
                    color = MedBlue, fontWeight = FontWeight.Medium
                )
            }

            Spacer(Modifier.height(6.dp))

            // Title
            Text(
                text = buildAnnotatedString {
                    append("Explore &\n")
                    withStyle(SpanStyle(color = Gold, fontStyle = FontStyle.Italic)) {
                        append("Discover")
                    }
                },
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = NavyText,
                lineHeight = 36.sp
            )

            Spacer(Modifier.height(4.dp))

            Text(
                "Choose how you want to play",
                fontSize = 11.sp, color = GrayMid, fontWeight = FontWeight.Light
            )

            Spacer(Modifier.height(16.dp))

            // ── 2×2 card grid ─────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MenuCardItem(cards[0], onClick = onStartGame)
                    MenuCardItem(cards[2], onClick = onStartGame) // Enabled Challenge card
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MenuCardItem(cards[1], onClick = onByCategory)
                    MenuCardItem(cards[3], onClick = onSettings)
                }
            }

            Spacer(Modifier.weight(1f))

            // ── Start button ──────────────────────────────────────────
            Button(
                onClick = onStartGame,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MedBlue)
            ) {
                Text(
                    "Start Playing",
                    fontSize = 14.sp, fontWeight = FontWeight.Medium,
                    color = Cream, letterSpacing = 0.3.sp
                )
            }

            Spacer(Modifier.height(8.dp))

            OutlinedButton(
                onClick = onSettings,
                modifier = Modifier.fillMaxWidth().height(46.dp),
                shape = RoundedCornerShape(12.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.5.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = NavyText)
            ) {
                Text("Settings", fontSize = 13.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}
