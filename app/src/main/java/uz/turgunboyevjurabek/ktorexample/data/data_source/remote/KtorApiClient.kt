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
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModel
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModelItem


class KtorApiClient {
    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }
    suspend fun getPosts():MyModel{
        val url= URLBuilder().apply {
            takeFrom("https://jsonplaceholder.typicode.com/todos/")
        }.build()

        return httpClient.get(url = url).body<MyModel>()

    }
}