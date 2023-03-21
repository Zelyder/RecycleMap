package com.zelyder.recyclemap.presentation.ui.learn.models

data class RecycleCode(
    val icon: Int,
    val description: String,
    val examples: String,
    val isNotRecyclable: Boolean = false
)
