package com.mediconear.sessionlib.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import com.mediconear.sessionlib.source.SessionSource
import io.reactivex.Completable

class SignIn(private val source: SessionSource) : CommandUseCaseWithParam<SignIn.SignInParam> {

    override fun invoke(param: SignInParam): Completable =
        source.signIn(param.email, param.password)

    class SignInParam(val email: String, val password: String)
}
