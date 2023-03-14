package com.trends.domain.repository

import com.trends.domain.model.WrappedMealsRemoteModel

interface MealsRepository {
    fun getMealsFromRemote():WrappedMealsRemoteModel
//    fun getMealsFromOffline():WrappedMealsRemoteModel
}