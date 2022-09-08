package com.mediconear.sessionlib.auth

import com.mediconear.sessionlib.store.SessionStore
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Intercepts outgoing requests and appends authorization header with JWT token to it
 */
class AuthHeaderInterceptor(private val store: SessionStore) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (request.isWithAccessToken()) {
            // Already has auth header
            return chain.proceed(request)
        }

        val authorizedRequest = request.newRequestWithAccessToken(store.getToken())

        return chain.proceed(authorizedRequest)
    }
}
