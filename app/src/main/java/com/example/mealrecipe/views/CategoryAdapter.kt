package com.example.mealrecipe.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealrecipe.R
import com.example.mealrecipe.models.Category

class CategoryAdapter(private var data: List<Category>) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = data[position]
        holder.categoryName.text = currentItem.name
    }
}