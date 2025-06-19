package com.example.dailyfacts.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfacts.R
import com.example.dailyfacts.model.retrofit.RetrofitHelper
import com.example.dailyfacts.model.retrofit.UselessFactApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FactAdapter(private val lifecycleScope: CoroutineScope):
    RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    inner class FactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val factText: TextView = itemView.findViewById(R.id.factTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder
    {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_pager, parent, false)

        return FactViewHolder(view)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int)
    {
        lifecycleScope.launch {
            try {
                val uselessFactApi = RetrofitHelper
                    .getInstance()
                    .create(UselessFactApi::class.java)

                val result = uselessFactApi.getRandomUselessFact()

                withContext(Dispatchers.Main) {
                    holder.factText.text = result.text
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    holder.factText.text = "Error loading"
                }
            }
        }
    }

    override fun getItemCount(): Int = 100 // статическое значение
}