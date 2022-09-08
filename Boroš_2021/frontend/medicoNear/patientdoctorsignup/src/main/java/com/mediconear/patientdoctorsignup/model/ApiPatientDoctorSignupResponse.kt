package com.mediconear.patientdoctorsignup.model

import com.mediconear.doctorslib.model.ApiDoctorResponse
import com.mediconear.patientlib.model.ApiPatientResponse
import com.mediconear.specializationtypelib.model.SpecializationType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiPatientDoctorSignupResponse(
    @Json(name = "prijava_id")
    val signUpId: Int,
    @Json(name = "lijecnik")
    val doctor: ApiDoctorResponse,
    @Json(name = "pacijent")
    val patient: ApiPatientResponse,
    @Json(name = "specijalnost")
    val specializationType: SpecializationType
)
