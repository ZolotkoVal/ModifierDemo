package com.example.modifierdemo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.modifierdemo.ui.theme.ModifierDemoTheme
import org.junit.Rule
import org.junit.Test

class DemoScreenTest {
    @get:Rule val composeRule = createComposeRule()

    @Test fun greetingIsVisible() {
        composeRule.setContent { ModifierDemoTheme { DemoScreen() } }
        composeRule.onNodeWithText("Hello Compose").assertIsDisplayed()
    }
}
