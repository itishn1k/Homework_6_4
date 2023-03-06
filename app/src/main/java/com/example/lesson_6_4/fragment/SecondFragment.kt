package com.example.lesson_6_4.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.lesson_6_4.MainViewModel
import com.example.lesson_6_4.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.totalClicks.observe(viewLifecycleOwner) {
            binding.tvCounterClick.text = it.toString()
        }
    }
}