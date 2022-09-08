package com.mediconear.patientlib.model

import com.mediconear.sessionlib.model.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PatientRequest(
    @Json(name = "pacijent_id")
    val patientId: Int,
    @Json(name = "mbo")
    val mbo: String,
    @Json(name = "korisnik")
    val user: User
)
