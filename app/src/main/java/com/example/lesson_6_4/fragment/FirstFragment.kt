package com.example.lesson_6_4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lesson_6_4.MainViewModel
import com.example.lesson_6_4.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickersAndSetData()
    }

    private fun initClickersAndSetData() {
        binding.btnInc.setOnClickListener { viewModel.onIncrementClick() }
        binding.btnDec.setOnClickListener { viewModel.onDecrementClick() }
        viewModel.currentCounter.observe(viewLifecycleOwner) {
            binding.tvCounter.text = it.toString()
        }
    }
}
