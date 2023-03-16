package com.trends.mealsapplication.di

import com.trends.data.datasource.MealsRemoteDataSource
import com.trends.data.repository.MealsRepositoryImpl
import com.trends.domain.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(mealsRemoteDataSource: MealsRemoteDataSource):MealsRepository{
        return MealsRepositoryImpl(mealsRemoteDataSource)
    }
}