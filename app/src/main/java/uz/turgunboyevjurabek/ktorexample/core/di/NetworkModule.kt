package uz.turgunboyevjurabek.ktorexample.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import uz.turgunboyevjurabek.ktorexample.data.data_source.remote.KtorApiClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient():HttpClient{
        return HttpClient(CIO){
            install(ContentNegotiation){
                json(
                    Json {
                        prettyPrint=true
                        isLenient=true
                        ignoreUnknownKeys=true
                    }
                )
            }
            install(Logging){
                level=LogLevel.ALL
            }
        }
    }

    @Singleton
    @Provides
    fun provideKtorApiClient(httpClient: HttpClient): KtorApiClient {
        return KtorApiClient(httpClient)
    }

}