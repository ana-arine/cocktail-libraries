package com.example.bibliotecascocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import com.example.bibliotecascocktail.adapters.TabsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberOfTabs = 2

        tabLayout.tabMode = TabLayout.MODE_FIXED

        tabLayout.isInlineLabel = true

        val adapter = TabsPagerAdapter(
            supportFragmentManager,
            lifecycle,
            numberOfTabs
        )

        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = true

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.alcoholic)
                1 -> tab.text = resources.getString(R.string.non_alcoholic)
            }
        }.attach()

       }
}