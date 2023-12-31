package com.example.mealrecipe.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealrecipe.R
import com.example.mealrecipe.models.Area
import com.example.mealrecipe.models.Category

class AreaAdapter(private var data: List<Area>, private val onItemClick: (Area) -> Unit) : RecyclerView.Adapter<AreaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list, parent, false)
        return AreaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        val currentItem = data[position]
        holder.categoryName.text = currentItem.name
        holder.itemView.setOnClickListener { onItemClick(currentItem) }
    }
}