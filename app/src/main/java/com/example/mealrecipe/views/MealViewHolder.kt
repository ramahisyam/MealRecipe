package com.example.mealrecipe.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealrecipe.R

class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mealName: TextView = itemView.findViewById(R.id.meal_name)
}