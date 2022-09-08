package com.mediconear.sessionlib.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "email")
    val email: String,
    @Json(name = "lozinka")
    val password: String,
    @Json(name = "ime")
    val firstName: String,
    @Json(name = "prezime")
    val lastName: String,
    @Json(name = "kontaktni_broj")
    val phoneNumber: String,
    @Json(name = "oib")
    val oib: String,
    @Json(name = "datum_rodjenja")
    val dob: String,
    @Json(name = "mbo")
    val mbo: String?,
    @Json(name = "adresa")
    val address: String?,
    @Json(name = "naziv_ordinacije")
    val ordiantionName: String?,
    @Json(name = "radno_vrijeme")
    val workingHours: String?,
    @Json(name = "isUserDoctor")
    val isUserDoctor: Boolean
)
