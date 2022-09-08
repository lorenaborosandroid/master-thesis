package com.mediconear.doctorslib.service

import com.mediconear.core.response.MessageResponse
import com.mediconear.core.response.UnitResponse
import com.mediconear.doctorslib.model.ApiDoctorResponse
import com.mediconear.doctorslib.model.ApiDoctorsResponse
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.model.DoctorRequest
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DoctorService {

    @GET("/api/doctors")
    fun getDoctors(): Flowable<ApiDoctorsResponse>

    @GET("/api/doctors/specialization/{id}")
    fun getDoctorsBySpecializationType(@Path("id") id: Int): Flowable<ApiDoctorsResponse>

    @POST("/api/doctors")
    fun updateDoctor(@Body request: DoctorRequest): Single<MessageResponse>

    @GET("/api/doctors/{id}")
    fun queryDoctorById(@Path("id") id: Int): Flowable<ApiDoctorResponse>
}
