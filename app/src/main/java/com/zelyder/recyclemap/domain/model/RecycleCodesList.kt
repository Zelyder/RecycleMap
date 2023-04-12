package com.zelyder.recyclemap.domain.model

import com.google.gson.annotations.SerializedName

data class RecycleCodesList(
    @SerializedName("data")
    val data: List<RecycleCode>
)