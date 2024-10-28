package uz.turgunboyevjurabek.ktorexample.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.ktorexample.presentation.components.MyTextLists
import uz.turgunboyevjurabek.ktorexample.presentation.viewmodel.MyViewModel

@Composable
fun MainScreen(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: MyViewModel = hiltViewModel()
){
    val posts by viewModel.posts.collectAsState()
    MyTextLists( posts = posts)

}