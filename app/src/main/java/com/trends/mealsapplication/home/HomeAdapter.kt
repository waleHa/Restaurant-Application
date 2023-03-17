package com.trends.mealsapplication.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trends.core.imageSetter
import com.trends.domain.model.MealsRemoteModel
import com.trends.mealsapplication.R

class HomeAdapter(
    private val list: List<MealsRemoteModel>
) : RecyclerView.Adapter<HomeAdapter.MealsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meals_item, parent, false)
        return MealsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        val currentMeal = list[position]
        holder.name.text = currentMeal.category
        holder.description.text = currentMeal.categoryDescription
        holder.image.imageSetter(currentMeal.categoryThumb)
    }

    override fun getItemCount(): Int = list.size ?: 0

    class MealsViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val name = viewItem.findViewById<TextView>(R.id.meal_name_text_view)
        val description = viewItem.findViewById<TextView>(R.id.meal_description_text_view)
        val image = viewItem.findViewById<ImageView>(R.id.meal_image_view)
    }
}


