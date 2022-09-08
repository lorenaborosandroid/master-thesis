package com.mediconear.sessionlib.auth

import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

/**
 * TokenAuthenticator is used to refresh session token once it expires and to
 * re-request failed responses under the hood failed because of the 401 - Unauthorized error
 *
 */
class TokenAuthenticator : Authenticator {

    private val tokenLock = Any()

    private val onUnauthorizedProcessor = PublishProcessor.create<Boolean>()

    fun onUnauthorized(): Flowable<Boolean> = onUnauthorizedProcessor

    /**
     * authenticate is called when a request failed because with 401 - Unauthorized due to outdated session token
     * This method should be thread-safe, as multiple requests can fail and call this method.
     */
    override fun authenticate(route: Route?, response: Response): Request? {
        /* We will use this flow when we get support from backend

        val accessToken: SessionToken = accessSessionTokenProvider.getAccessToken()
        if (!response.request().isWithAccessToken() || accessToken.isEmpty()) {
            return null
        }
        synchronized(tokenLock) {
            val newAccessToken: SessionToken = accessSessionTokenProvider.getAccessToken()
            // Access token is refreshed in another thread.
            if (accessToken != newAccessToken) {
                return response.request().newRequestWithAccessToken(newAccessToken.accessToken)
            }

            // Need to refresh an access token
            val updatedAccessToken: SessionToken = accessSessionTokenProvider.refreshAndGetAccessToken()

            if (updatedAccessToken.isEmpty()) {
                return null
            }

            return response.request().newRequestWithAccessToken(updatedAccessToken.accessToken)
        }
         */

        onUnauthorizedProcessor.onNext(true)
        return null
    }
}
