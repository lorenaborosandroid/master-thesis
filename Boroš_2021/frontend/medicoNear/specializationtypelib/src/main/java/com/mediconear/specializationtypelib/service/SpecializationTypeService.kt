package com.mediconear.specializationtypelib.service

import com.mediconear.specializationtypelib.model.ApiSpecializationTypes
import io.reactivex.Flowable
import retrofit2.http.GET

interface SpecializationTypeService {

    @GET("/api/specijalizacija")
    fun querySpecializationTypes(): Flowable<ApiSpecializationTypes>
}
