package com.zelyder.recyclemap.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "learn")
data class LearnEntity(
    val name: Int,
    val image: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
