package uz.turgunboyevjurabek.ktorexample.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.turgunboyevjurabek.ktorexample.presentation.screens.MainScreen
import uz.turgunboyevjurabek.ktorexample.presentation.screens.PostsScreen

@Composable
fun MyNavigation(modifier: Modifier = Modifier,navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main" ) {
        composable("main"){
            MainScreen(modifier = modifier,navController = navController,)
        }
        composable("post"){
            PostsScreen(navController = navController)
        }
    }
}

