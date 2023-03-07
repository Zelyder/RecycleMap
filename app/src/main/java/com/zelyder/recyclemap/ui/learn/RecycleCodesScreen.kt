package com.zelyder.recyclemap.ui.learn

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.ui.learn.models.RecycleCode

val mockCodesList = listOf(
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
    RecycleCode(
        icon = R.drawable.plastic_recyc_01,
        description = "Полиэтилентерефталат (лавсан)",
        examples = "Полиэстер, бутылки для напитков",
    ),
)

@Preview
@Composable
fun RecycleCodesScreen() {
    LazyColumn {
        items(mockCodesList) {code ->
            RecycleCodeItem(code)
        }
    }
}