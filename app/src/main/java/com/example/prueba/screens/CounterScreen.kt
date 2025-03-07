package com.example.prueba.screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.prueba.viewModel.CounterViewModel
import com.example.prueba.widgets.Contador

@Composable
fun CounterScreen(navController: NavController, viewModel: CounterViewModel) {
    Contador(navController, viewModel)
}