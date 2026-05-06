package com.example.dhouhaelaouni.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import com.example.dhouhaelaouni.R

private val Cream      = Color(0xFFF7F3EC)
private val NavyText   = Color(0xFF2C2C2A)
private val MedBlue    = Color(0xFF4A7FB5)
private val Gold       = Color(0xFFB8860B)
private val GrayMid    = Color(0xFF888780)
private val GrayLight  = Color(0xFFE8E4DC)
private val GreenDark  = Color(0xFF3B6D11)

// ── Performance tier based on accuracy ────────────────────────────────────────
private data class PerformanceTier(
    val medal: String,
    val title: String,
    val titleAccent: String,
    val subtitle: String
)

private fun getPerformance(accuracy: Int): PerformanceTier = when {
    accuracy >= 90 -> PerformanceTier("🏆", "History", "Legend!", "Outstanding knowledge of Tunisian heritage!")
    accuracy >= 70 -> PerformanceTier("🥇", "History", "Expert!", "You really know your Tunisian heritage")
    accuracy >= 50 -> PerformanceTier("🎓", "Good", "Explorer!", "You're learning the heritage well")
    accuracy >= 30 -> PerformanceTier("📖", "Keep", "Exploring!", "Tunisia has more secrets to reveal")
    else           -> PerformanceTier("🌱", "Just", "Getting Started!", "Every expert was once a beginner")
}

@Composable
fun ResultScreen(
    score: Int,
    correctCount: Int,
    totalQuestions: Int,
    category: Category,
    difficulty: Difficulty,
    onPlayAgain: () -> Unit,
    onChooseCategory: () -> Unit
) {
    val accuracy = if (totalQuestions > 0)
        ((correctCount.toFloat() / totalQuestions) * 100).toInt() else 0
    val tier = getPerformance(accuracy)

    // Animate accuracy bar on enter
    var animStarted by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { animStarted = true }
    val animatedAccuracy by animateFloatAsState(
        targetValue = if (animStarted) accuracy / 100f else 0f,
        animationSpec = tween(1000),
        label = "accuracy"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ── Hero image ─────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // Fade to cream at bottom
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            0.3f to Cream.copy(alpha = 0f),
                            1.0f to Cream
                        )
                    )
            )
            // Category badge
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 52.dp)
                    .background(Cream.copy(alpha = 0.92f), RoundedCornerShape(99.dp))
                    .padding(horizontal = 14.dp, vertical = 5.dp)
            ) {
                Text(
                    "${category.displayName} · ${difficulty.displayName}",
                    fontSize = 10.sp, fontWeight = FontWeight.Medium, color = NavyText
                )
            }
        }

        // ── Medal ──────────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .size(72.dp)
                .background(Color(0xFFFFF8E6), CircleShape)
                .border(2.5.dp, Gold, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(tier.medal, fontSize = 32.sp)
        }

        Spacer(Modifier.height(12.dp))

        // ── Performance label ──────────────────────────────────────────
        Text(
            "YOUR RESULT",
            fontSize = 10.sp, letterSpacing = 2.sp,
            color = MedBlue, fontWeight = FontWeight.Medium
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = buildAnnotatedString {
                append(tier.title + " ")
                withStyle(SpanStyle(color = Gold, fontStyle = FontStyle.Italic)) {
                    append(tier.titleAccent)
                }
            },
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = NavyText,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(4.dp))

        Text(
            tier.subtitle,
            fontSize = 12.sp, color = GrayMid,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light
        )

        Spacer(Modifier.height(24.dp))

        // ── Stat cards ─────────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatCard(
                value = "$score",
                label = "Total Score",
                valueColor = Gold,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                value = "$correctCount/$totalQuestions",
                label = "Correct",
                valueColor = GreenDark,
                modifier = Modifier.weight(1f)
            )
            StatCard(
                value = "$accuracy%",
                label = "Accuracy",
                valueColor = MedBlue,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(Modifier.height(20.dp))

        // ── Accuracy bar ───────────────────────────────────────────────
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Accuracy", fontSize = 11.sp, color = GrayMid)
                Text("$accuracy%", fontSize = 11.sp, color = GrayMid)
            }
            Spacer(Modifier.height(6.dp))
            LinearProgressIndicator(
                progress = { animatedAccuracy },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(99.dp)),
                color = if (accuracy >= 50) MedBlue else Gold,
                trackColor = GrayLight,
                strokeCap = StrokeCap.Round
            )
        }

        Spacer(Modifier.height(28.dp))

        // ── Buttons ────────────────────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = onPlayAgain,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MedBlue)
            ) {
                Text(
                    if (accuracy >= 50) "Play Again" else "Try Again",
                    fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Cream
                )
            }

            OutlinedButton(
                onClick = onChooseCategory,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.5.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = NavyText)
            ) {
                Text("Choose Category", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}

// ── Stat card ─────────────────────────────────────────────────────────────────
@Composable
private fun StatCard(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.5.dp, GrayLight, RoundedCornerShape(12.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(value, fontSize = 20.sp, fontWeight = FontWeight.Medium, color = valueColor)
        Text(label, fontSize = 10.sp, color = GrayMid, textAlign = TextAlign.Center,
            lineHeight = 14.sp)
    }
}