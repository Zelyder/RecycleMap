package com.zelyder.recyclemap.presentation.ui.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.presentation.ui.learn.models.RecycleCode
import com.zelyder.recyclemap.presentation.ui.learn.components.RecycleCodeItem

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


@Composable
fun LearnDetailsScreen(title: String?) {
    Column {
        title?.let { Text(it) }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(mockCodesList) { code ->
                RecycleCodeItem(code)
            }
        }
    }
}