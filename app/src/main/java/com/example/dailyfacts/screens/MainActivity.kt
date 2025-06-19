package com.example.dailyfacts.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.dailyfacts.databinding.ActivityMainBinding
import com.example.dailyfacts.model.FactAdapter
import com.example.dailyfacts.model.retrofit.RetrofitHelper
import com.example.dailyfacts.model.retrofit.UselessFactApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.factViewPager
        viewPager.adapter = FactAdapter(lifecycleScope)


        binding.themeBtn.setOnClickListener {
            val intent = Intent(this, ThemeActivity::class.java)
            startActivity(intent)
        }
    }
}