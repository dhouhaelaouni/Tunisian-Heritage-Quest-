package com.example.dhouhaelaouni.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import com.example.dhouhaelaouni.ui.components.AnswerButton
import com.example.dhouhaelaouni.ui.components.ScoreDisplay
import com.example.dhouhaelaouni.ui.components.TimerBar
import com.example.dhouhaelaouni.viewmodel.QuizViewModel

// ── Colors ────────────────────────────────────────────────────────────────────
private val Cream      = Color(0xFFF7F3EC)
private val NavyText   = Color(0xFF2C2C2A)
private val MedBlue    = Color(0xFF4A7FB5)
private val BluLight   = Color(0xFFEEF3FB)
private val BluBorder  = Color(0xFFB5D4F4)
private val BluDark    = Color(0xFF0C447C)
private val GrayMid    = Color(0xFF888780)
private val GrayLight  = Color(0xFFE8E4DC)

@Composable
fun QuizScreen(
    category: Category,
    difficulty: Difficulty,
    timerEnabled: Boolean,
    showFunFacts: Boolean,
    onExit: () -> Unit,
    onFinished: (score: Int, correct: Int, total: Int) -> Unit,
    viewModel: QuizViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    // Start quiz once
    LaunchedEffect(category, difficulty) {
        viewModel.startQuiz(category, difficulty, timerEnabled, showFunFacts)
    }

    // Navigate when finished
    LaunchedEffect(state.isFinished) {
        if (state.isFinished) {
            onFinished(state.score, state.correctCount, state.questions.size)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        state.currentQuestion?.let { question ->

            // ── Top bar ───────────────────────────────────────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 52.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onExit() }
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Exit",
                        tint = MedBlue, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Exit", fontSize = 12.sp, color = MedBlue)
                }
                ScoreDisplay(score = state.score)
            }

            // ── Progress bar ──────────────────────────────────────────
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Question ${state.currentIndex + 1} of ${state.questions.size}",
                        fontSize = 10.sp, color = GrayMid)
                    Text(question.category.displayName,
                        fontSize = 10.sp, color = GrayMid)
                }
                Spacer(Modifier.height(6.dp))
                val animatedProgress by animateFloatAsState(
                    targetValue = state.progress, animationSpec = tween(400), label = "progress"
                )
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(99.dp)),
                    color = MedBlue,
                    trackColor = GrayLight,
                    strokeCap = StrokeCap.Round
                )
            }

            Spacer(Modifier.height(12.dp))

            // ── Timer ─────────────────────────────────────────────────
            if (timerEnabled && !state.isAnswered) {
                Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                    TimerBar(timeLeft = state.timeLeft)
                }
                Spacer(Modifier.height(12.dp))
            }

            // ── Monument image ─────────────────────────────────────────
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                androidx.compose.foundation.Image(
                    painter = painterResource(question.imageRes),
                    contentDescription = "Monument image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Badge bottom-left
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(10.dp)
                        .background(Cream.copy(alpha = 0.92f), RoundedCornerShape(99.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        "${question.category.displayName} · ${question.difficulty.displayName}",
                        fontSize = 10.sp, fontWeight = FontWeight.Medium, color = NavyText
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            // ── Question text ─────────────────────────────────────────
            Text(
                question.questionText,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = NavyText,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(horizontal = 20.dp),
                lineHeight = 26.sp
            )

            Spacer(Modifier.height(12.dp))

            // ── Answer options ────────────────────────────────────────
            val letters = listOf("A", "B", "C", "D")
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                question.options.forEachIndexed { index, option ->
                    AnswerButton(
                        text = option,
                        letter = letters[index],
                        isSelected = state.selectedAnswerIndex == index,
                        isCorrect = index == question.correctAnswerIndex,
                        isAnswered = state.isAnswered,
                        onClick = { viewModel.selectAnswer(index) }
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            // ── Fun fact card ─────────────────────────────────────────
            AnimatedVisibility(
                visible = state.showFunFact && showFunFacts && question.funFact.isNotEmpty(),
                enter = fadeIn() + expandVertically()
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(BluLight, RoundedCornerShape(14.dp))
                            .border(1.5.dp, BluBorder, RoundedCornerShape(14.dp))
                            .padding(12.dp)
                    ) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text("💡", fontSize = 14.sp)
                                Text("FUN FACT", fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF185FA5), letterSpacing = 1.sp)
                            }
                            Spacer(Modifier.height(6.dp))
                            Text(question.funFact, fontSize = 12.sp,
                                color = BluDark, lineHeight = 18.sp)
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }

            // ── Next button ───────────────────────────────────────────
            AnimatedVisibility(visible = state.isAnswered) {
                Button(
                    onClick = { viewModel.nextQuestion() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 32.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MedBlue)
                ) {
                    Text(
                        if (state.currentIndex + 1 >= state.questions.size)
                            "See Results" else "Next Question →",
                        fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Cream
                    )
                }
            }
        }
    }
}
