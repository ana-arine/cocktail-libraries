package com.example.bibliotecascocktail.fragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bibliotecascocktail.R
import com.example.bibliotecascocktail.adapters.DrinkAdapter
import com.example.bibliotecascocktail.model.Drink
import com.example.bibliotecascocktail.model.ListDrinks
import com.example.bibliotecascocktail.service.ApiServiceNonAlcoholic
import com.example.bibliotecascocktail.service.NetworkUtils
import kotlinx.android.synthetic.main.fragment_non_alcoholic.*
import kotlinx.android.synthetic.main.fragment_non_alcoholic.progressBar2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class NonAlcoholicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_non_alcoholic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitClient = NetworkUtils.getRetrofitInstance()
        val endpoint = retrofitClient.create(ApiServiceNonAlcoholic::class.java)

        progressBar2.visibility = View.VISIBLE

                val callback = endpoint.listAllCategoriesNA()
        callback.enqueue(object : Callback<ListDrinks> {

        override fun onResponse(
            call: Call<ListDrinks>,
            response: Response<ListDrinks>
        ) {
            response.body()?.let {
                progressBar2.visibility = View.GONE
                configureList(it)
            }
        }


        override fun onFailure(call: Call<ListDrinks>, t: Throwable?) {
            progressBar2.visibility = View.GONE
            Log.i("URL", call.request().url().toString())
            Log.i("URL", t?.message.toString())
            Toast.makeText(context, "Loading error!", Toast.LENGTH_SHORT).show()
        }
    })
}

    private fun configureList(categories: ListDrinks) {
        val drinkAdapter = DrinkAdapter(listDrinks = categories)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        rvNADrinks.layoutManager = linearLayoutManager
        rvNADrinks.adapter = drinkAdapter


    }

}
