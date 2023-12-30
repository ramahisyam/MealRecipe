package com.example.mealrecipe.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealrecipe.R

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val categoryName: TextView = itemView.findViewById(R.id.category_name)
}