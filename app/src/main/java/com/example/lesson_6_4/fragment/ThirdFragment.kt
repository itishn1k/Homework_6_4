package com.example.lesson_6_4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.lesson_6_4.MainViewModel
import com.example.lesson_6_4.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        viewModel.totalClicks.observe(viewLifecycleOwner) {
            val adapter = ThirdFragmentAdapter()
            binding.rvHistory.adapter = adapter
            adapter.addToList(viewModel.clickHistory.reversed())
        }
    }
}