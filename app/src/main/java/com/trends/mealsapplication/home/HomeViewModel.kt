package com.trends.mealsapplication.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trends.domain.model.MealsRemoteModel
import com.trends.domain.usecase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase
) : ViewModel() {

    private val _mealsListingSuccess = MutableLiveData<List<MealsRemoteModel>?>()
    var mealsListingSuccess: LiveData<List<MealsRemoteModel>?> = _mealsListingSuccess

    private val _mealsListingError = MutableLiveData<Exception>()
    val mealsListingError: LiveData<Exception> = _mealsListingError

    private val _loadingLiveData = MutableLiveData<Boolean>(true)
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    init {
        getMeals()
    }

    private fun getMeals() {
        viewModelScope.launch {
            try {
                _mealsListingSuccess.value = getMealsUseCase()
            } catch (e: Exception) {
                _mealsListingError.value = e
            }
            _loadingLiveData.postValue(false)
        }
    }
}