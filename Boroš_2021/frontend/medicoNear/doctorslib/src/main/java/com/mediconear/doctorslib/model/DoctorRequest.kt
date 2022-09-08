package com.mediconear.doctorslib.model

import com.mediconear.sessionlib.model.User
import com.mediconear.specializationtypelib.model.SpecializationType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DoctorRequest(
    @Json(name = "lijecnik_id")
    val doctorId: Int,
    @Json(name = "naziv_ordinacije")
    val practiceName: String,
    @Json(name = "specijalnost")
    val specializationType: SpecializationType,
    @Json(name = "adresa")
    val address: String,
    @Json(name = "radno_vrijeme")
    val workingHours: String,
    @Json(name = "korisnik")
    val user: User
)
