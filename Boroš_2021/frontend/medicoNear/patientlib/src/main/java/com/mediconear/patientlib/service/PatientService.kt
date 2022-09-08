package com.mediconear.patientlib.service

import com.mediconear.patientlib.model.ApiPatientResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface PatientService {

    @GET("/api/patients/{id}")
    fun queryPatientById(@Path("id") id: Int): Flowable<ApiPatientResponse>
}
