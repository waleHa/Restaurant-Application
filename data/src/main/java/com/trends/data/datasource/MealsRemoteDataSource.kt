package com.trends.data.datasource

import com.trends.domain.model.WrappedMealsRemoteModel
import retrofit2.http.GET

interface MealsRemoteDataSource {
    @GET("categories.php")
    fun getMeals(): WrappedMealsRemoteModel
}