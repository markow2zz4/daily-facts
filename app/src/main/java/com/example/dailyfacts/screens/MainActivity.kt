package com.example.dailyfacts.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.dailyfacts.databinding.ActivityMainBinding
import com.example.dailyfacts.model.FactAdapter
import com.example.dailyfacts.R
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fontResId = intent.getIntExtra("fontResId", R.font.caveat_regular)
        val bgColorId = intent.getIntExtra("bgColorId", R.color.default_bg)

        binding.main.setBackgroundColor(ContextCompat.getColor(this, bgColorId))
        window.statusBarColor = ContextCompat.getColor(this, bgColorId)

        viewPager = binding.factViewPager
        viewPager.adapter = FactAdapter(lifecycleScope, fontResId)


        binding.themeBtn.setOnClickListener {
            val intent = Intent(this, ThemeActivity::class.java)
            startActivity(intent)
        }

        binding.categoryBtn.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }

        binding.settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        val prefs = getSharedPreferences("theme_prefs", MODE_PRIVATE)
        prefs.edit()
            .putInt("bgColorId", R.color.default_bg)
            .putInt("fontResId", R.font.caveat_regular)
    }
}