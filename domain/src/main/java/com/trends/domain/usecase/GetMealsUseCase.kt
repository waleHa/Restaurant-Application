package com.trends.domain.usecase

import com.trends.domain.repository.MealsRepository

class GetMealsUseCase(private val mealsRepository: MealsRepository) {
    suspend operator fun invoke() = mealsRepository.getMealsFromRemote()
}