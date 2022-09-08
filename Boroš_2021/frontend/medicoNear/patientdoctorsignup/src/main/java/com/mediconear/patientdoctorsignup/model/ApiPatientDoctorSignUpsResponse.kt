package com.mediconear.patientdoctorsignup.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiPatientDoctorSignUpsResponse(
    @Json(name = "signups")
    val signups: List<ApiPatientDoctorSignupResponse>
)
