package com.mediconear.sessionlib.response

import com.mediconear.sessionlib.model.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SignInResponse(
    @Json(name = "token")
    val accessToken: String,
    @Json(name = "korisnik")
    val user: User
)
