package com.trends.data.repository

import com.trends.data.datasource.MealsRemoteDataSource
import com.trends.domain.model.MealsRemoteModel
import com.trends.domain.model.WrappedMealsRemoteModel
import com.trends.domain.repository.MealsRepository

class MealsRepositoryImpl(private val mealsRemoteDataSource: MealsRemoteDataSource):MealsRepository {
    override suspend fun getMealsFromRemote(): List<MealsRemoteModel> = mealsRemoteDataSource.getMeals().meals
}