package com.trends.data.repository

import com.trends.data.datasource.MealsRemoteDataSource
import com.trends.domain.model.WrappedMealsRemoteModel
import com.trends.domain.repository.MealsRepository

class MealsRepositoryImpl(private val mealsRemoteDataSource: MealsRemoteDataSource):MealsRepository {
    override fun getMealsFromRemote(): WrappedMealsRemoteModel = mealsRemoteDataSource.getMeals()
}