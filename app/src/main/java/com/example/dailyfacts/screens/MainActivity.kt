package com.example.dailyfacts.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dailyfacts.databinding.ActivityMainBinding
import com.example.dailyfacts.model.retrofit.RetrofitHelper
import com.example.dailyfacts.model.retrofit.UselessFactApi

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uselessFactApi = RetrofitHelper
            .getInstance()
            .create(UselessFactApi::class.java)

//        binding.button.setOnClickListener {
//            lifecycleScope.launch {
//                val result = uselessFactApi.getRandomUselessFact()
//
//                runOnUiThread {
//                    binding.textView.text = result.text
//                }
//            }
//        }

        binding.button.setOnClickListener {
            val intent = Intent(this, ThemeActivity::class.java)
            startActivity(intent)
        }
    }
}