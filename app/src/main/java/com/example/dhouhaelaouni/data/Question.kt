package com.example.dhouhaelaouni.data

data class Question(
    val id: Int,
    val imageRes: Int,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val category: Category,
    val difficulty: Difficulty,
    val funFact: String = "",
    val questionText: String = "Which monument or place is this?"
)

enum class Category(val displayName: String) {
    ROMAN("Roman Heritage"),
    ISLAMIC("Islamic Heritage"),
    PUNIC("Punic & Pre-Roman"),
    MODERN("Modern Heritage"),
    NATURAL("Natural & Mixed Sites"),
    CITIES("Cities")
}

enum class Difficulty(val displayName: String) {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard")
}