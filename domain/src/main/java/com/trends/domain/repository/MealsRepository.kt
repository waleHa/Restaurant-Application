package com.trends.domain.repository

import com.trends.domain.model.MealsRemoteModel
import com.trends.domain.model.WrappedMealsRemoteModel

interface MealsRepository {
    suspend fun getMealsFromRemote():List<MealsRemoteModel>
//    fun getMealsFromOffline():WrappedMealsRemoteModel
}