package com.example.mealrecipe.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealrecipe.R
import com.example.mealrecipe.models.Area
import com.example.mealrecipe.models.Meal

class MealAdapter(private var data: List<Meal>) : RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_list, parent, false)
        return MealViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val currentItem = data[position]
        holder.mealName.text = currentItem.name
    }
}