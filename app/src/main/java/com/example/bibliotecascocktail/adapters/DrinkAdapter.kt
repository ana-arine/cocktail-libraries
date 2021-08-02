package com.example.bibliotecascocktail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions
import com.example.bibliotecascocktail.R
import com.example.bibliotecascocktail.model.Drink
import com.example.bibliotecascocktail.model.ListDrinks

class DrinkAdapter(private val listDrinks: ListDrinks) :
RecyclerView.Adapter<DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val layoutItem = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        val viewHolder = DrinkViewHolder(layoutItem)
        return viewHolder
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {

        val categoryData: Drink = listDrinks.drinks[position]
        holder.name.text = categoryData.drinkName

        val urlImageCategory = categoryData.drinkImage

        Glide.with(holder.image)
            .load(urlImageCategory)
            .apply(RequestOptions().override(100, 100))
            .into(holder.image)

    }

    override fun getItemCount(): Int = listDrinks.drinks.size


}