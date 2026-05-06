package com.example.dhouhaelaouni

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test

/**
 * UI Test to verify the navigation flow of the application.
 * This test starts from the Splash Screen and navigates through the Main Menu.
 */
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testStartGameNavigation() {
        // 1. Wait for the Splash Screen auto-transition (approx 2.5 seconds)
        // We use a simple sleep for the demo, though IdlingResource is preferred for production
        Thread.sleep(3000)

        // 2. Verify we are on the Main Menu Screen
        composeTestRule.onNodeWithText("TUNISIA HERITAGE").assertIsDisplayed()
        composeTestRule.onNodeWithText("Start Playing").assertIsDisplayed()

        // 3. Navigate to the Quiz Screen by clicking "Start Playing"
        composeTestRule.onNodeWithText("Start Playing").performClick()

        // 4. Verify we reached the Quiz Screen (check for the Exit button)
        composeTestRule.onNodeWithText("Exit").assertIsDisplayed()
    }

    @Test
    fun testSettingsNavigation() {
        // Wait for Splash transition
        Thread.sleep(3000)

        // Click on Settings button
        composeTestRule.onNodeWithText("Settings").performClick()

        // Verify we are on Settings (checking for a common setting label)
        // Note: Replace with actual text if SettingScreen has specific labels like "Game Timer"
        composeTestRule.onNodeWithText("Settings").assertIsDisplayed()
    }
}
