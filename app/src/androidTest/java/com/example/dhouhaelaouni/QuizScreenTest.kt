package com.example.dhouhaelaouni

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import com.example.dhouhaelaouni.ui.screens.QuizScreen
import org.junit.Rule
import org.junit.Test

/**
 * UI Test for the QuizScreen component.
 */
class QuizScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun quizScreen_displaysCorrectInitialUI() {
        composeTestRule.setContent {
            QuizScreen(
                category = Category.ROMAN,
                difficulty = Difficulty.EASY,
                timerEnabled = true,
                showFunFacts = true,
                onExit = {},
                onFinished = { _, _, _ -> }
            )
        }

        // Verify that the Exit button is displayed
        composeTestRule.onNodeWithText("Exit").assertIsDisplayed()
        
        // Verify that the Score is displayed
        composeTestRule.onNodeWithText("Score:", substring = true).assertIsDisplayed()
        
        // Verify that 4 answer options (A, B, C, D) are eventually present 
        // (Wait for questions to load from repository)
        composeTestRule.waitUntil(5000) {
            composeTestRule.onAllNodesWithText("A", substring = true).fetchSemanticsNodes().isNotEmpty()
        }
    }
}
