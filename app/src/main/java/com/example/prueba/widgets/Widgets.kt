package com.example.prueba.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prueba.Routes
import com.example.prueba.viewModel.CounterViewModel

@Composable
fun Counter(number: Int) {
    Text(text = number.toString(), fontSize = 50.sp)
}

@Composable
fun CounterButton(onClick: () -> Unit, text: String) {
    Button(onClick = { onClick() }, Modifier.width(150.dp)) {
        Text(text = text)
    }
}

@Composable
fun NavigateButton(onClick: () -> Unit, text: String) {
    Button(onClick = { onClick() }, Modifier.width(150.dp)) {
        Text(text = text)
    }
}

@Composable
fun Contador(
    navController: NavController,
    viewModel: CounterViewModel) {

    val contador = viewModel.counter.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Counter(number = contador.value)
            CounterButton(
                onClick = { viewModel.increment()},
                text = "Sumar"
            )
            NavigateButton(
                onClick = { navController.navigate(Routes.createNumberRoute(contador.value)) },
                text = "Continuar"
            )
        }
    }
}
