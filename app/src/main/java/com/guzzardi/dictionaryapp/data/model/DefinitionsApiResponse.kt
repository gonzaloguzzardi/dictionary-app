package com.guzzardi.dictionaryapp.data.model

import com.squareup.moshi.Json

data class DefinitionsApiResponse(@field:Json(name = "list") val definitions: List<DefinitionItemDto>?)