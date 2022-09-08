package com.mediconear.patientdoctorsignup.model

import com.mediconear.doctorslib.model.DoctorRequest
import com.mediconear.patientlib.model.PatientRequest
import com.mediconear.specializationtypelib.model.ApiSpecializationTypeRequest
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PatientDoctorSignUpRequest(
    @Json(name = "lijecnik_id")
    val doctor: DoctorRequest,
    @Json(name = "pacijent_id")
    val patient: PatientRequest,
    @Json(name = "specijalizacija_id")
    val apiSpecializationType: ApiSpecializationTypeRequest
)
