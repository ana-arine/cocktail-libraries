package com.example.bibliotecascocktail.model

import com.google.gson.annotations.SerializedName

data class ListDrinks(
    @SerializedName("drinks") var drinks: List<Drink>
)
