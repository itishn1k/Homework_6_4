package com.example.lesson_6_4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var counter = 0
    private var totalCount = 0
    val currentCounter = MutableLiveData<Int>()
    val totalClicks = MutableLiveData<Int>()
    val clickHistory = mutableListOf<String>()

    fun onIncrementClick() {
        ++counter
        currentCounter.value = counter
        totalCounter()
        clickHistory += "+1"
    }

    fun onDecrementClick() {
        --counter
        currentCounter.value = counter
        totalCounter()
        clickHistory += "-1"
    }

    private fun totalCounter() {
        ++totalCount
        totalClicks.value = totalCount
    }
}