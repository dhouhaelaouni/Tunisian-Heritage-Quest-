package com.example.dhouhaelaouni.data

import org.junit.Assert.*
import org.junit.Test

class QuestionRepositoryTest {

    @Test
    fun `getByCategory returns only questions from that category`() {
        val romanQuestions = QuestionRepository.getByCategory(Category.ROMAN)
        assertTrue(romanQuestions.all { it.category == Category.ROMAN })
        assertTrue(romanQuestions.isNotEmpty())
    }

    @Test
    fun `getByDifficulty returns only questions of that difficulty`() {
        val easyQuestions = QuestionRepository.getByDifficulty(Difficulty.EASY)
        assertTrue(easyQuestions.all { it.difficulty == Difficulty.EASY })
        assertTrue(easyQuestions.isNotEmpty())
    }

    @Test
    fun `getByCategoryAndDifficulty filters correctly`() {
        val filtered = QuestionRepository.getByCategoryAndDifficulty(Category.ROMAN, Difficulty.EASY)
        assertTrue(filtered.all { it.category == Category.ROMAN && it.difficulty == Difficulty.EASY })
    }

    @Test
    fun `all questions have unique IDs`() {
        val ids = QuestionRepository.allQuestions.map { it.id }
        assertEquals(ids.size, ids.distinct().size)
    }

    @Test
    fun `all questions have four options`() {
        assertTrue(QuestionRepository.allQuestions.all { it.options.size == 4 })
    }
}
