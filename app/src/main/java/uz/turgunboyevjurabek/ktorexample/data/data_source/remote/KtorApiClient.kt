package uz.turgunboyevjurabek.ktorexample.data.data_source.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModelItem
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyPostModel
import javax.inject.Inject


class KtorApiClient @Inject constructor(private val httpClient: HttpClient) {

    suspend fun getTodos():List<MyModelItem>?{
//        val url= URLBuilder().apply {
//            takeFrom("https://jsonplaceholder.typicode.com/todos/1")
//        }.build()

        return try {
            val url = "https://jsonplaceholder.typicode.com/todos/" // URLni to‘g‘ridan-to‘g‘ri ishlatish
            httpClient.get(url).body()
        } catch (e: Exception) {
            println("Error fetching posts: ${e.message}")
            null
        }
    }

    suspend fun getPosts():List<MyPostModel>?{
        return try {
            val url="https://jsonplaceholder.typicode.com/posts/"
            httpClient.get(url).body()
        }catch (e:Exception){
            println("Error fetching posts: ${e.message}")
            null
        }
    }

}