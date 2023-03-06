package com.example.lesson_6_4

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lesson_6_4.fragment.FirstFragment
import com.example.lesson_6_4.fragment.SecondFragment
import com.example.lesson_6_4.fragment.ThirdFragment

class PagesAdapter(activity: MainActivity) :
    FragmentStateAdapter(activity) {

    private val fragments = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
