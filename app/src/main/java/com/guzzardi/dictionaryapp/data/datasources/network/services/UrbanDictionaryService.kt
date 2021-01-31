package com.guzzardi.dictionaryapp.data.datasources.network.services

import com.guzzardi.dictionaryapp.BuildConfig
import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UrbanDictionaryService {

    @Headers(
        "x-rapidapi-key: ${BuildConfig.RAPID_API_KEY}",
        "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
        "useQueryString: true"
    )
    @GET("/define")
    suspend fun getDefinitionForWord(@Query("term") word: String): List<DefinitionItemDto>
}
