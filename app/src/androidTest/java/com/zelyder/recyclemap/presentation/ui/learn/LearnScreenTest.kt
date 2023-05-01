package com.zelyder.recyclemap.presentation.ui.learn

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.zelyder.recyclemap.presentation.MainActivity
import com.zelyder.recyclemap.presentation.navigation.FakeRouter
import com.zelyder.recyclemap.presentation.ui.theme.RecycleMapTheme
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class LearnScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun isPlasticSectionOpened() = runTest{
        val router = FakeRouter()
        composeTestRule.setContent {
            RecycleMapTheme {
                LearnScreen(externalRouter = router)
            }
        }

        composeTestRule.onNodeWithText("Пластик").assertIsDisplayed()

//        composeTestRule.onNodeWithTag("Title")
//            .assertTextEquals("Пластик")

    }
}