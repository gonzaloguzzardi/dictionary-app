package com.guzzardi.dictionaryapp.data.datasources.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.guzzardi.dictionaryapp.BuildConfig
import com.guzzardi.dictionaryapp.data.datasources.DataSource
import com.guzzardi.dictionaryapp.data.datasources.network.RemoteDataSource
import com.guzzardi.dictionaryapp.data.datasources.network.services.UrbanDictionaryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com"

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
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
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSource): DataSource = remoteDataSource

}