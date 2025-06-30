package com.example.dailyfacts.model

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfacts.R
import com.example.dailyfacts.screens.MainActivity
import kotlin.math.log

class ThemeAdapter(
    private val items: List<Int>,

): RecyclerView.Adapter<ThemeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //он получает картинку (будущий шаблон)
        val imageView: ImageView = view.findViewById(R.id.themeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // создает новый viewHolder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_theme_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Вызывается при отображении конкретного элемента
        holder.imageView.setImageResource(items[position])

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, MainActivity::class.java)

            when(position) {

                0 -> {
                    intent.putExtra("fontResId", R.font.caveat_regular)
                    intent.putExtra("bgColorId", R.color.background_red)
                    holder.itemView.context.startActivity(intent)
                }

                1 -> {
                    intent.putExtra("fontResId", R.font.gentium_book_plus_regular)
                    intent.putExtra("bgColorId", R.color.background_yellow)
                    holder.itemView.context.startActivity(intent)
                }

            }
        }

    }

    override fun getItemCount(): Int = items.size
}