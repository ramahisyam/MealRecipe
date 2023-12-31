package com.example.mealrecipe.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        //RecyclerView type of food
        val rvCategory = binding.rvCategory
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        mainViewModel.categoryResponse.observe(this){ categoryResponse ->
            val categoryAdapter = CategoryAdapter(categoryResponse.data){category ->
                val intent = Intent(this, MealActivity::class.java)
                intent.putExtra("QUERY", "c")
                intent.putExtra("CATEGORY_NAME", category.name) // Pass any relevant data to the next activity
                startActivity(intent)
                Toast.makeText(this, "Clicked ${category.name}", Toast.LENGTH_SHORT).show()
            }
            rvCategory.adapter = categoryAdapter
        }

        mainViewModel.getArea()
        //RecyclerView area
        val rvArea = binding.rvArea
        rvArea.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        mainViewModel.areaResponse.observe(this){ areaResponse ->
            val areaAdapter = AreaAdapter(areaResponse.data){area ->
                val intent = Intent(this, MealActivity::class.java)
                intent.putExtra("QUERY", "a")
                intent.putExtra("CATEGORY_NAME", area.name) // Pass any relevant data to the next activity
                startActivity(intent)
                Toast.makeText(this, "Clicked ${area.name}", Toast.LENGTH_SHORT).show()
            }
            rvArea.adapter = areaAdapter
        }
    }
}