package uz.turgunboyevjurabek.ktorexample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyPost
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyPostModel
import uz.turgunboyevjurabek.ktorexample.domain.repository.MyRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {
    private val _posts = MutableStateFlow<List<MyPostModel>?>(emptyList())
    val posts = _posts.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val fetchedPosts = repository.getPosts()
                _posts.emit(fetchedPosts)
            } catch (e: Exception) {
                println("obbo postda -> ${e.message}")
            }
        }
    }

    fun createPost(post: MyPost) {
        viewModelScope.launch {
            try {
                val createdPost = repository.createPost(post)
                println("success created post")
            } catch (e: Exception) {
                println("obbo postingda -> ${e.message}")
            }
        }

    }
}