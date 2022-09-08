package com.mediconear.sessionlib.source

import com.mediconear.sessionlib.request.SignUpRequest
import io.reactivex.Completable

interface SessionSource {

    fun signOut(): Completable

    fun signIn(email: String, password: String): Completable

    fun signUp(request: SignUpRequest): Completable
}
