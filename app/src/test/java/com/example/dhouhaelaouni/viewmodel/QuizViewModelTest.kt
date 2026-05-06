package com.example.dhouhaelaouni.viewmodel

import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class QuizViewModelTest {

    private lateinit var viewModel: QuizViewModel

    @Before
    fun setup() {
        viewModel = QuizViewModel()
    }

    @Test
    fun `startQuiz initializes state correctly`() {
        viewModel.startQuiz(
            category = Category.ROMAN,
            difficulty = Difficulty.EASY,
            timerEnabled = true,
            showFunFacts = true
        )

        val state = viewModel.uiState.value
        assertFalse(state.questions.isEmpty())
        assertEquals(0, state.currentIndex)
        assertEquals(0, state.score)
        assertNull(state.selectedAnswerIndex)
    }

    @Test
    fun `selectAnswer updates score and correctCount when correct`() {
        viewModel.startQuiz(Category.ROMAN, Difficulty.EASY, false, true)
        val initialQuestion = viewModel.uiState.value.currentQuestion!!
        val correctIndex = initialQuestion.correctAnswerIndex

        viewModel.selectAnswer(correctIndex)

        val state = viewModel.uiState.value
        assertEquals(correctIndex, state.selectedAnswerIndex)
        assertTrue(state.score > 0)
        assertEquals(1, state.correctCount)
    }

    @Test
    fun `selectAnswer does not update score when incorrect`() {
        viewModel.startQuiz(Category.ROMAN, Difficulty.EASY, false, true)
        val initialQuestion = viewModel.uiState.value.currentQuestion!!
        val incorrectIndex = (initialQuestion.correctAnswerIndex + 1) % 4

        viewModel.selectAnswer(incorrectIndex)

        val state = viewModel.uiState.value
        assertEquals(0, state.score)
        assertEquals(0, state.correctCount)
    }

    @Test
    fun `nextQuestion increments index`() {
        viewModel.startQuiz(Category.ROMAN, Difficulty.EASY, false, true)
        val initialQuestion = viewModel.uiState.value.currentQuestion!!
        viewModel.selectAnswer(initialQuestion.correctAnswerIndex)
        
        viewModel.nextQuestion()

        assertEquals(1, viewModel.uiState.value.currentIndex)
        assertNull(viewModel.uiState.value.selectedAnswerIndex)
    }
}
