package com.example.dailyfacts.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dailyfacts.R
import com.example.dailyfacts.databinding.ActivityCategoryBinding
import com.example.dailyfacts.databinding.ActivityThemeBinding
import com.example.dailyfacts.model.ThemeAdapter

class ThemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityThemeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val imageList = listOf(
            R.drawable.red_theme,
            R.drawable.green_theme,
            R.drawable.purple_theme,
            R.drawable.yellow_theme,
            R.drawable.peach_pink_theme,
            R.drawable.green_peach_theme,
        )

        binding.themesRecyclerView.layoutManager = GridLayoutManager(this, 2) // 2 в ряд
        binding.themesRecyclerView.adapter = ThemeAdapter(imageList)

        binding.imageButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}