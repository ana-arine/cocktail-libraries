package com.example.bibliotecascocktail.service

import com.example.bibliotecascocktail.model.Drink
import com.example.bibliotecascocktail.model.ListDrinks
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceAlcoholic {

    @GET("json/v1/1/filter.php?a=Alcoholic")

    fun listAllCategoriesA(): Call<ListDrinks>

}