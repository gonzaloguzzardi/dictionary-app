package com.guzzardi.dictionaryapp.hilt.testmodules

import com.guzzardi.dictionaryapp.data.datasources.DataSource
import com.guzzardi.dictionaryapp.data.datasources.network.services.UrbanDictionaryService
import com.guzzardi.dictionaryapp.di.AppModule
import com.guzzardi.dictionaryapp.hilt.fakes.FakeRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
interface FakeAppModule {
    companion object {
        private const val BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com"
    }

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): UrbanDictionaryService =
        retrofit.create(UrbanDictionaryService::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteDataSource: FakeRemoteDataSource): DataSource = remoteDataSource
}