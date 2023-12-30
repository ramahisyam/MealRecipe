package com.example.mealrecipe.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.R
import com.example.mealrecipe.databinding.ActivityMainBinding
import com.example.mealrecipe.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.getCategory()
        val rvCategory = binding.rvCategory
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        mainViewModel.categoryResponse.observe(this){ categoryResponse ->
            val categoryAdapter = CategoryAdapter(categoryResponse.data)
            rvCategory.adapter = categoryAdapter
        }
    }
}