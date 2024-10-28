package uz.turgunboyevjurabek.ktorexample.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.ktorexample.R
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyPost
import uz.turgunboyevjurabek.ktorexample.presentation.components.PostsList
import uz.turgunboyevjurabek.ktorexample.presentation.viewmodel.PostViewModel

@Composable
fun PostsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: PostViewModel = hiltViewModel()
) {
    val posts by viewModel.posts.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(onClick = {
            viewModel.createPost(
                MyPost(
                    body = "Turgunboyev Jo'rabek",
                    title = "Allambalo",
                    userId = 7
                )
            )
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_circle_add),
                contentDescription = null,
                modifier = modifier
                    .size(30.dp)
            )
        }
        PostsList(posts = posts)
    }


}