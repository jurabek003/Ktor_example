package uz.turgunboyevjurabek.ktorexample.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.ktorexample.presentation.components.PostsList
import uz.turgunboyevjurabek.ktorexample.presentation.viewmodel.PostViewModel

@Composable
fun PostsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: PostViewModel= hiltViewModel()
) {
    val posts by viewModel.posts.collectAsState()

    PostsList(posts = posts)

}