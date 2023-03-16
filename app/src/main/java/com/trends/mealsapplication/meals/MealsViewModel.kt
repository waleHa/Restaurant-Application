package com.trends.mealsapplication.meals

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trends.domain.model.WrappedMealsRemoteModel
import com.trends.domain.usecase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase
) : ViewModel() {

    private val _meals:MutableLiveData<WrappedMealsRemoteModel?>? = null
    var meals: LiveData<WrappedMealsRemoteModel?>? = _meals


    fun getMeals() {
        viewModelScope.launch {
            try {
                _meals?.value = getMealsUseCase()
            } catch (e:Exception) {
                Log.e("MealsViewModel",e.localizedMessage.toString())
            }
        }
    }

}