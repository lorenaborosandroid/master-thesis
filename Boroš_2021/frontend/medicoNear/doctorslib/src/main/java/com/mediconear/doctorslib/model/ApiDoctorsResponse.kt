package com.mediconear.doctorslib.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ApiDoctorsResponse(
    @Json(name = "doctors")
    val doctors: List<ApiDoctorResponse>
)
