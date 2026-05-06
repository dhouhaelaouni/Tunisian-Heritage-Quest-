package com.example.dhouhaelaouni

import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import com.example.dhouhaelaouni.viewmodel.QuizViewModel
import org.junit.Assert.*
import org.junit.Test

class IntegrationTest {
    @Test
    fun testViewModelDataFlow() {
        val viewModel = QuizViewModel()
        // Start quiz for a specific category
        viewModel.startQuiz(Category.ISLAMIC, Difficulty.EASY, false, false)
        
        val state = viewModel.uiState.value
        // Verify ViewModel successfully pulled data from Repository
        assertNotNull(state.currentQuestion)
        assertEquals(Category.ISLAMIC, state.currentQuestion?.category)
        
        // Ensure only 10 questions are taken (as per logic)
        assertEquals(10, state.questions.size)
    }
}
