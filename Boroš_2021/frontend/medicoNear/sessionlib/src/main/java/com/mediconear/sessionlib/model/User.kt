package com.mediconear.sessionlib.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "korisnik_id")
    val userId: Int,
    @Json(name = "lozinka")
    val password: String?,
    @Json(name = "email")
    val email: String,
    @Json(name = "ime")
    val firstName: String,
    @Json(name = "prezime")
    val lastName: String,
    @Json(name = "oib")
    val oib: String,
    @Json(name = "datum_rodjenja")
    val dob: String,
    @Json(name = "kontakt_broj")
    val phoneNumber: String
) {

    companion object {
        val EMPTY = User(0, "", "", "", "", "", "", "")
    }
}
