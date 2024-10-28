package uz.turgunboyevjurabek.ktorexample.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.turgunboyevjurabek.ktorexample.data.data_source.remote.KtorApiClient
import uz.turgunboyevjurabek.ktorexample.domain.repository.MyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMyRepository(apiClient: KtorApiClient): MyRepository {
        return MyRepository(apiClient)
    }


}