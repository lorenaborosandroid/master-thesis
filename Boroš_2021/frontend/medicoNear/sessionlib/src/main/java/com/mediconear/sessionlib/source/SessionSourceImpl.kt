package com.mediconear.sessionlib.source

import com.mediconear.sessionlib.request.SignInRequest
import com.mediconear.sessionlib.request.SignUpRequest
import com.mediconear.sessionlib.response.SignInResponse
import com.mediconear.sessionlib.service.SessionService
import com.mediconear.sessionlib.store.SessionStore
import io.reactivex.Completable

class SessionSourceImpl(
    private val service: SessionService,
    private val store: SessionStore
) : SessionSource {

    override fun signOut(): Completable =
        Completable.fromAction { store.clearAccessToken() }

    override fun signIn(email: String, password: String): Completable =
        service.signIn(SignInRequest(email, password))
            .flatMapCompletable(::mapOutErrorOrCreateUserSession)

    private fun mapOutErrorOrCreateUserSession(response: SignInResponse): Completable =
        Completable.fromAction {
            store.saveToken(response.accessToken)
            store.saveUser(response.user)
        }

    override fun signUp(request: SignUpRequest): Completable =
        service.signUp(request)
            .flatMapCompletable {
                Completable.complete()
            }
}
