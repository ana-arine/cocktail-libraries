package com.example.bibliotecascocktail.model

import com.google.gson.annotations.SerializedName

data class Drink (
    @SerializedName("strDrink") var drinkName : String,
    @SerializedName("strDrinkThumb") var drinkImage : String
        )