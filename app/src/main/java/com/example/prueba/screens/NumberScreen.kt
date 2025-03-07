package com.example.prueba.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.prueba.Routes
import com.example.prueba.viewModel.CounterViewModel
import com.example.prueba.widgets.Counter
import com.example.prueba.widgets.NavigateButton

@Composable
fun NumberScreen(navController: NavController, viewModel: CounterViewModel) {
    val contador = viewModel.counter.collectAsState()
    Box(
        Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Counter(contador.value)
            NavigateButton(
                onClick = { navController.navigate(Routes.COUNTER_SCREEN) },
                text = "Atras" )
        }
    }
}
