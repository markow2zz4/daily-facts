package com.example.dailyfacts

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.dailyfacts.databinding.ActivityMainBinding
import com.example.dailyfacts.model.retrofit.RetrofitHelper
import com.example.dailyfacts.model.retrofit.UselessFactApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uselessFactApi = RetrofitHelper
            .getInstance()
            .create(UselessFactApi::class.java)

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                val result = uselessFactApi.getRandomUselessFact()

                runOnUiThread {
                    binding.textView.text = result.text
                }
            }
        }
    }
}