package com.mediconear.core.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MessageResponse(
    @Json(name = "message")
    val message: String
)
