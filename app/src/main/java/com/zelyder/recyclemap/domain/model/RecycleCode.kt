package com.zelyder.recyclemap.domain.model

import com.google.gson.annotations.SerializedName


data class RecycleCode(
    @SerializedName("description")
    val description: String,
    @SerializedName("examples")
    val examples: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("iso")
    val iso: String,
    @Transient
    val icon: Int? = null,
    @SerializedName("isNotRecyclable")
    val isNotRecyclable: Boolean = false
)
