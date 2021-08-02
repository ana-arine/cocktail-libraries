package com.example.bibliotecascocktail.service

import com.example.bibliotecascocktail.model.Drink
import com.example.bibliotecascocktail.model.ListDrinks
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceNonAlcoholic {

    @GET("json/v1/1/filter.php?a=Non_Alcoholic")

    fun listAllCategoriesNA(): Call<ListDrinks>

}