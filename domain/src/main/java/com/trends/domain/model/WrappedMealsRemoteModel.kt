package com.trends.domain.model


import com.google.gson.annotations.SerializedName

data class WrappedMealsRemoteModel(
    @SerializedName("categories")
    val meals: List<MealsRemoteModel>
)