package com.example.prueba.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterViewModel: ViewModel() {
    var counter = MutableStateFlow(0)

    fun increment() {
        counter.value++
    }
}