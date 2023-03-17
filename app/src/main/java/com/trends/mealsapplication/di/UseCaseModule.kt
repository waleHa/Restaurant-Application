package com.trends.mealsapplication.di

import com.trends.domain.repository.MealsRepository
import com.trends.domain.usecase.GetMealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(mealsRepository: MealsRepository): GetMealsUseCase {
        return GetMealsUseCase(mealsRepository)
    }
}