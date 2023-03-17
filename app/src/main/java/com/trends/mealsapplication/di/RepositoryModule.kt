package com.trends.mealsapplication.di

import com.trends.data.datasource.MealsRemoteDataSource
import com.trends.data.repository.MealsRepositoryImpl
import com.trends.domain.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(mealsRemoteDataSource: MealsRemoteDataSource): MealsRepository {
        return MealsRepositoryImpl(mealsRemoteDataSource)
    }
}
