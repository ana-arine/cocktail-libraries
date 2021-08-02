package com.example.bibliotecascocktail.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliotecascocktail.R

class DrinkViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val name: TextView
    val image: ImageView

    init {
        name = itemView.findViewById(R.id.txtName)
        image = itemView.findViewById(R.id.imgDrink)
    }
}