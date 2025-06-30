package com.example.dailyfacts.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfacts.R
import com.example.dailyfacts.databinding.ActivityCategoryBinding
import com.example.dailyfacts.databinding.ActivityThemeBinding
import com.example.dailyfacts.model.ThemeAdapter

class ThemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = listOf(
            R.drawable.red_theme,
            R.drawable.yellow_theme,
            R.drawable.green_theme,
            R.drawable.purple_theme,
            R.drawable.peach_pink_theme,
            R.drawable.green_peach_theme,
        )

        val recyclerView = binding.themesRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2) //Grid / Linear

        val adapter = ThemeAdapter(imageList)
        recyclerView.adapter = adapter


//        binding.themesRecyclerView.layoutManager = GridLayoutManager(this, 2) // 2 в ряд
//        binding.themesRecyclerView.adapter = ThemeAdapter(imageList)

        binding.imageButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}