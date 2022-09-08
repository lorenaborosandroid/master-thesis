package com.mediconear.authentication.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import io.reactivex.Completable

/**
 * Inititates authentication and after it's successful inititates given action
 */
class WithAuthentication(private val authenticate: Authenticate) : CommandUseCaseWithParam<Completable> {

    override fun invoke(param: Completable): Completable =
        authenticate()
            .andThen(param)
}
