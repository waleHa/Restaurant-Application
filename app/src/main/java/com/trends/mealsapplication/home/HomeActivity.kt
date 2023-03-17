package com.trends.mealsapplication.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.trends.domain.model.MealsRemoteModel
import com.trends.mealsapplication.databinding.ActivityHomeBinding
import com.trends.mealsapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater);
        setContentView(binding.root);
        observeLiveData()

    }

    private fun setupRecyclerView(list: List<MealsRemoteModel>) {
        recyclerView = binding.recyclerViewMeals
        adapter = HomeAdapter(list)
        recyclerView.adapter = adapter

    }

    private fun observeLiveData() {
        viewModel.mealsListingSuccess.observe(this, ::handleSuccess)
        viewModel.loadingLiveData.observe(this, ::handleLoading)
        viewModel.mealsListingError.observe(this, ::handleError)
    }

    private fun handleError(exception: Exception?) {
        Toast.makeText(this, "Error ${exception?.localizedMessage.toString()}", Toast.LENGTH_LONG)
            .show()
    }

    private fun handleLoading(b: Boolean) {
        binding.progressBar.isVisible = b
    }

    private fun handleSuccess(mealsRemoteModel: List<MealsRemoteModel>?) {
        setupRecyclerView(requireNotNull(mealsRemoteModel))
    }
}
