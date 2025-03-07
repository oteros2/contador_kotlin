package com.example.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.prueba.screens.CounterScreen
import com.example.prueba.screens.NumberScreen
import com.example.prueba.viewModel.CounterViewModel

object Routes {
    const val COUNTER_SCREEN = "counterScreen"
    const val NUMBER_SCREEN = "numberScreen/{number}"
    fun createNumberRoute(number: Int) = "numberScreen/$number"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: CounterViewModel = viewModel(viewModelStoreOwner = LocalViewModelStoreOwner.current!!)

            NavHost(
                navController = navController,
                startDestination = Routes.COUNTER_SCREEN
            ) {
                composable(Routes.COUNTER_SCREEN) {
                    CounterScreen(navController, viewModel)
                }
                composable(
                    Routes.NUMBER_SCREEN,
                    arguments = listOf(navArgument("number") { type = IntType })
                ) { backStackEntry ->
                    NumberScreen(
                       navController, viewModel
                    )
                }
            }
        }
    }
}




