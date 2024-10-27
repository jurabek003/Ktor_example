package uz.turgunboyevjurabek.ktorexample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModel
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModelItem
import uz.turgunboyevjurabek.ktorexample.domain.repository.MyRepository

class MyViewModel(private val repository: MyRepository):ViewModel() {
    private val _posts= MutableStateFlow(MyModel())
    val posts=_posts.asStateFlow()
    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val fetchedPosts = repository.getPosts()
                _posts.emit(fetchedPosts)
            } catch (e: Exception) {
                // Xatolikni qayd etish
                println("Error fetching posts: ${e.message}")
            }
        }
    }
}