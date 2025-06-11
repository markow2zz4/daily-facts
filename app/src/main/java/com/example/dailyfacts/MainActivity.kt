package com.example.dailyfacts

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val checkBtn = binding.button
        val factTv = binding.textView

        val uselessFactApi = RetrofitHelper
            .getInstance()
            .create(UselessFactApi::class.java)



        checkBtn.setOnClickListener {
            GlobalScope.launch {
                val result = uselessFactApi.getRandomUselessFact()

                runOnUiThread {
                    factTv.text = result.text
                }
            }
        }



    }

    override fun onStop() {
        super.onStop()
        GlobalScope.cancel()
    }
}