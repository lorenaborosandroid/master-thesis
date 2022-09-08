package com.mediconear.sessionlib.service

import com.mediconear.core.response.MessageResponse
import com.mediconear.sessionlib.response.SignInResponse
import com.mediconear.sessionlib.request.SignInRequest
import com.mediconear.sessionlib.request.SignUpRequest
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SessionService {

    @POST("/api/auth/signin")
    fun signIn(@Body request: SignInRequest): Single<SignInResponse>

    @POST("/api/auth/signup")
    fun signUp(@Body request: SignUpRequest): Single<MessageResponse>
}
