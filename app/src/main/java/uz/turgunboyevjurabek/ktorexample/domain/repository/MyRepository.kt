package uz.turgunboyevjurabek.ktorexample.domain.repository

import uz.turgunboyevjurabek.ktorexample.data.data_source.remote.KtorApiClient
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModelItem
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyPostModel

class MyRepository(private val apiClient: KtorApiClient) {

    suspend fun getTodos(): List<MyModelItem>? {
        return apiClient.getTodos()
    }

    suspend fun getPosts(): List<MyPostModel>? {
        return apiClient.getPosts()
    }

}