package com.example.bibliotecascocktail.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bibliotecascocktail.fragments.AlcoholicFragment
import com.example.bibliotecascocktail.fragments.NonAlcoholicFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numAbas: Int)
    :FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = numAbas


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlcoholicFragment()
            1 -> NonAlcoholicFragment()
            else -> AlcoholicFragment()
        }
    }

}