package com.guzzardi.dictionaryapp.data.model

import com.squareup.moshi.Json

data class DefinitionItemDto(
    val definition: String?,
    val author: String?,
    @field:Json(name = "thumbs_up") val upVotes: Int?,
    @field:Json(name = "thumbs_down") val downVotes: Int?
)