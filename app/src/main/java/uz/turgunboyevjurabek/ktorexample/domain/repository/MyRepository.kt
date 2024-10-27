package uz.turgunboyevjurabek.ktorexample.domain.repository

import uz.turgunboyevjurabek.ktorexample.data.data_source.remote.KtorApiClient
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModel
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModelItem

class MyRepository(private val apiClient: KtorApiClient)  {
    suspend fun getPosts(): MyModel {
        return apiClient.getPosts()
    }

}