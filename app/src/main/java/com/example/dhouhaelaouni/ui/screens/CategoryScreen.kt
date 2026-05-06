package com.example.dhouhaelaouni.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dhouhaelaouni.data.Category

private val Cream      = Color(0xFFF7F3EC)
private val NavyText   = Color(0xFF2C2C2A)
private val MedBlue    = Color(0xFF4A7FB5)
private val BluLight   = Color(0xFFF0F6FC)
private val Gold       = Color(0xFFB8860B)
private val GrayMid    = Color(0xFF888780)
private val GrayLight  = Color(0xFFD3D1C7)
private val CardBorder = Color(0xFFE8E4DC)

data class CategoryUiItem(
    val category: Category,
    val emoji: String,
    val iconBg: Color,
    val questionCount: String
)

@Composable
fun CategoryScreen(
    onBack: () -> Unit,
    onCategorySelected: (Category) -> Unit
) {
    val categories = listOf(
        CategoryUiItem(Category.ROMAN,   "🏛️", Color(0xFFFDF0E6), "10–15 questions"),
        CategoryUiItem(Category.ISLAMIC, "🕌", Color(0xFFEAF3DE), "10–15 questions"),
        CategoryUiItem(Category.PUNIC,   "⚓", Color(0xFFFFF8E6), "5–10 questions"),
        CategoryUiItem(Category.MODERN,  "🏛️", Color(0xFFEEF3FB), "5–10 questions"),
        CategoryUiItem(Category.NATURAL, "🌿", Color(0xFFE6F5EE), "5–10 questions"),
        CategoryUiItem(Category.CITIES,  "🏙️", Color(0xFFFEF0F0), "5–10 questions"),
    )

    var selected by remember { mutableStateOf<Category?>(null) }

    Column(modifier = Modifier.fillMaxSize().background(Cream)) {

        // ── Header ────────────────────────────────────────────────────
        Column(modifier = Modifier.padding(horizontal = 22.dp).padding(top = 52.dp, bottom = 14.dp)) {

            // Back
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onBack() }
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back",
                    tint = MedBlue, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text("Back", fontSize = 12.sp, color = MedBlue)
            }

            Spacer(Modifier.height(14.dp))

            // Title
            Text(
                text = buildAnnotatedString {
                    append("Choose a\n")
                    withStyle(SpanStyle(color = Gold, fontStyle = FontStyle.Italic)) {
                        append("Category")
                    }
                },
                fontSize = 28.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.SemiBold,
                color = NavyText
            )

            Spacer(Modifier.height(4.dp))

            Text(
                "Select a heritage theme to explore",
                fontSize = 11.sp,
                color = GrayMid,
                fontWeight = FontWeight.Light
            )
        }

        // Divider
        Divider(color = GrayLight, thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 22.dp))

        // ── Category list ─────────────────────────────────────────────
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 22.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(categories) { item ->
                val isSelected = selected == item.category
                CategoryCard(
                    item = item,
                    isSelected = isSelected,
                    onClick = {
                        selected = item.category
                        onCategorySelected(item.category)
                    }
                )
            }
        }
    }
}

@Composable
private fun CategoryCard(
    item: CategoryUiItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (isSelected) BluLight else Color.White,
                RoundedCornerShape(14.dp)
            )
            .border(
                1.5.dp,
                if (isSelected) MedBlue else CardBorder,
                RoundedCornerShape(14.dp)
            )
            .clickable { onClick() }
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Emoji icon box
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(item.iconBg, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(item.emoji, fontSize = 18.sp)
        }

        // Text info
        Column(modifier = Modifier.weight(1f)) {
            Text(
                item.category.displayName,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Medium,
                color = NavyText
            )
            Text(
                item.questionCount,
                fontSize = 11.sp,
                color = GrayMid
            )
        }

        // Arrow
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = if (isSelected) MedBlue else GrayLight,
            modifier = Modifier.size(20.dp)
        )
    }
}