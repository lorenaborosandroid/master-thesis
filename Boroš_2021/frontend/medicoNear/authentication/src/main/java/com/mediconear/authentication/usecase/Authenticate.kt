package com.mediconear.authentication.usecase

import com.mediconear.authentication.source.AuthenticationSource
import com.mediconear.core.usecase.CommandUseCase
import io.reactivex.Completable

/**
 * Inititates user authentification
 */
class Authenticate(private val authenticationSource: AuthenticationSource) : CommandUseCase {

    override fun invoke(): Completable = authenticationSource.authenticate()
}
