package com.mediconear.patientdoctorsignup.service

import com.mediconear.core.response.MessageResponse
import com.mediconear.patientdoctorsignup.model.ApiPatientDoctorSignUpsResponse
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUpRequest
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PatientDoctorSignUpService {

    @GET("/api/prijava")
    fun getPatientDoctorSignUp(): Flowable<ApiPatientDoctorSignUpsResponse>

    @POST("/api/prijava")
    fun createPatientDoctorSignUp(@Body request: PatientDoctorSignUpRequest): Single<MessageResponse>
}
