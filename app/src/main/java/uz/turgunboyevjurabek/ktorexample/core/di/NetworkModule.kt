package uz.turgunboyevjurabek.ktorexample.core.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.FileStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import uz.turgunboyevjurabek.ktorexample.data.data_source.remote.KtorApiClient
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @SuppressLint("NewApi")
    @Provides
    @Singleton
    fun provideHttpClient(context: Context):HttpClient{
        return HttpClient(CIO){

            install(HttpCache){
                // Android kesh papkasiga murojaat qilamiz
                val cacheDir = File(context.cacheDir, "http_cache")
                cacheDir.mkdirs() // Agar papka mavjud bo'lmasa, yaratiladi
                publicStorage(FileStorage(cacheDir))
            }

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