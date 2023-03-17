package com.trends.domain.model


import com.google.gson.annotations.SerializedName

data class MealsRemoteModel(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String,
    @SerializedName("strCategoryThumb")
    val categoryThumb: String
)