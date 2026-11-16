package com.example.modifierdemo

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import com.example.modifierdemo.ui.theme.ModifierDemoTheme
import org.junit.Rule
import org.junit.Test

class DemoScreenTest {
    @get:Rule val composeRule = createComposeRule()

    @Test fun greetingIsVisible() {
        composeRule.setContent { ModifierDemoTheme { DemoScreen() } }
        composeRule.onNodeWithText("Hello Compose").assertIsDisplayed()
    }

    @Test fun vacationImageHasAccessibleDescription() {
        composeRule.setContent { ModifierDemoTheme { DemoScreen() } }
        composeRule.onNodeWithContentDescription("Скалистый берег во время отпуска")
            .assertIsDisplayed()
    }

    @Test fun customImageWorksWithDefaultModifier() {
        composeRule.setContent {
            CustomImage(R.drawable.vacation, contentDescription = "Default modifier image")
        }
        composeRule.onNodeWithContentDescription("Default modifier image").assertIsDisplayed()
    }

    @Test fun customImageForwardsSuppliedSizeModifier() {
        composeRule.setContent {
            CustomImage(
                R.drawable.vacation,
                Modifier.size(width = 123.dp, height = 80.dp),
                contentDescription = "Sized image"
            )
        }
        composeRule.onNodeWithContentDescription("Sized image")
            .assertIsDisplayed()
            .assertWidthIsEqualTo(123.dp)
            .assertHeightIsEqualTo(80.dp)
    }

    @Test fun thenAddsHeightInsideTextPadding() {
        composeRule.setContent { ModifierDemoTheme { DemoScreen() } }
        composeRule.onNodeWithText("Hello Compose").assertHeightIsEqualTo(100.dp)
    }
}
