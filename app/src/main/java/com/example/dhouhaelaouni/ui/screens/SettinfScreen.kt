package com.example.dhouhaelaouni.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dhouhaelaouni.data.Difficulty

// ── Theme colors (consistent across all screens) ──────────────────────────────
private val Cream      = Color(0xFFF7F3EC)
private val NavyText   = Color(0xFF2C2C2A)
private val MedBlue    = Color(0xFF4A7FB5)
private val Gold       = Color(0xFFB8860B)
private val GrayMid    = Color(0xFF888780)
private val GrayLight  = Color(0xFFD3D1C7)
private val CardBorder = Color(0xFFE8E4DC)
private val CardBg     = Color(0xFFF0EDE6)

@Composable
fun SettingScreen(
    onBack: () -> Unit,
    onSave: (timerEnabled: Boolean, difficulty: Difficulty, showFunFacts: Boolean, soundEnabled: Boolean) -> Unit
) {
    // ── State ─────────────────────────────────────────────────────────
    var timerEnabled   by remember { mutableStateOf(true) }
    var showFunFacts   by remember { mutableStateOf(true) }
    var soundEnabled   by remember { mutableStateOf(false) }
    var difficulty     by remember { mutableStateOf(Difficulty.MEDIUM) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Header ────────────────────────────────────────────────────
        Column(modifier = Modifier.padding(horizontal = 22.dp).padding(top = 52.dp, bottom = 16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onBack() }
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back",
                    tint = MedBlue, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text("Back", fontSize = 12.sp, color = MedBlue)
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    append("Game\n")
                    withStyle(SpanStyle(color = Gold, fontStyle = FontStyle.Italic)) {
                        append("Settings")
                    }
                },
                fontSize = 28.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.SemiBold,
                color = NavyText
            )
            Spacer(Modifier.height(3.dp))
            Text("Customize your experience", fontSize = 11.sp,
                color = GrayMid, fontWeight = FontWeight.Light)
        }

        Divider(color = GrayLight, thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 22.dp))

        Column(
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // ── Gameplay section ──────────────────────────────────────
            SettingsSection(label = "Gameplay") {

                // Timer toggle
                SettingsToggleRow(
                    icon = "⏱️",
                    iconBg = Color(0xFFEEF3FB),
                    title = "Timer",
                    hint = "15 seconds per question",
                    checked = timerEnabled,
                    onCheckedChange = { timerEnabled = it }
                )

                Divider(color = CardBg, thickness = 1.dp)

                // Difficulty pills
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .background(Color(0xFFFFF8E6), RoundedCornerShape(9.dp)),
                        contentAlignment = Alignment.Center
                    ) { Text("⭐", fontSize = 16.sp) }

                    Text("Difficulty", fontSize = 13.sp,
                        fontWeight = FontWeight.Medium, color = NavyText,
                        modifier = Modifier.weight(1f))

                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Difficulty.entries.forEach { d ->
                            val active = difficulty == d
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(99.dp))
                                    .background(if (active) MedBlue else Color.Transparent)
                                    .border(1.5.dp, if (active) MedBlue else GrayLight,
                                        RoundedCornerShape(99.dp))
                                    .clickable { difficulty = d }
                                    .padding(horizontal = 10.dp, vertical = 5.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    d.displayName.take(3),
                                    fontSize = 11.sp,
                                    color = if (active) Cream else GrayMid,
                                    fontWeight = if (active) FontWeight.Medium else FontWeight.Normal
                                )
                            }
                        }
                    }
                }

                Divider(color = CardBg, thickness = 1.dp)

                // Fun facts toggle
                SettingsToggleRow(
                    icon = "💡",
                    iconBg = Color(0xFFEAF3DE),
                    title = "Show fun facts",
                    hint = "After each answer",
                    checked = showFunFacts,
                    onCheckedChange = { showFunFacts = it }
                )
            }

            // ── Sound section ─────────────────────────────────────────
            SettingsSection(label = "Sound") {
                SettingsToggleRow(
                    icon = "🔊",
                    iconBg = Color(0xFFEEF3FB),
                    title = "Sound effects",
                    hint = "Correct / wrong sounds",
                    checked = soundEnabled,
                    onCheckedChange = { soundEnabled = it }
                )
            }

            // ── About section ─────────────────────────────────────────
            SettingsSection(label = "About") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .background(Color(0xFFFFF8E6), RoundedCornerShape(9.dp)),
                        contentAlignment = Alignment.Center
                    ) { Text("ℹ️", fontSize = 16.sp) }

                    Column {
                        Text("Version", fontSize = 13.sp,
                            fontWeight = FontWeight.Medium, color = NavyText)
                        Text("Tunisia Heritage Quest v1.0",
                            fontSize = 11.sp, color = GrayMid)
                    }
                }
            }

            // ── Save button ───────────────────────────────────────────
            Button(
                onClick = { onSave(timerEnabled, difficulty, showFunFacts, soundEnabled) },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MedBlue)
            ) {
                Text("Save Settings", fontSize = 14.sp,
                    fontWeight = FontWeight.Medium, color = Cream)
            }
        }
    }
}

// ── Reusable section wrapper ──────────────────────────────────────────────────
@Composable
private fun SettingsSection(label: String, content: @Composable ColumnScope.() -> Unit) {
    Column {
        Text(
            label.uppercase(),
            fontSize = 10.sp,
            letterSpacing = 1.5.sp,
            color = GrayMid,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(14.dp))
                .border(1.5.dp, CardBorder, RoundedCornerShape(14.dp))
        ) {
            content()
        }
    }
}

// ── Reusable toggle row ───────────────────────────────────────────────────────
@Composable
private fun SettingsToggleRow(
    icon: String,
    iconBg: Color,
    title: String,
    hint: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(iconBg, RoundedCornerShape(9.dp)),
            contentAlignment = Alignment.Center
        ) { Text(icon, fontSize = 16.sp) }

        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = NavyText)
            Text(hint, fontSize = 11.sp, color = GrayMid)
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = MedBlue,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = GrayLight,
                uncheckedBorderColor = GrayLight
            )
        )
    }
}