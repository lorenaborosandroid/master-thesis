package com.mediconear.authentication.usecase

import com.mediconear.authentication.source.AuthenticationSource
import com.mediconear.core.usecase.CommandUseCase
import io.reactivex.Completable

/**
 * Indicate that current authentication has succeeded
 */
class AuthenticationHasSucceeded(private val authenticationSource: AuthenticationSource) : CommandUseCase {

    override fun invoke(): Completable = authenticationSource.currentAuthenticationHasSucceeded()
}
