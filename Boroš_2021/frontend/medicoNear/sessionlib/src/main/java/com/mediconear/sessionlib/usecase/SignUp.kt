package com.mediconear.sessionlib.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import com.mediconear.sessionlib.request.SignUpRequest
import com.mediconear.sessionlib.source.SessionSource
import io.reactivex.Completable

class SignUp(private val source: SessionSource, private val signIn: SignIn) : CommandUseCaseWithParam<SignUp.SignUpParam> {

    override fun invoke(param: SignUpParam): Completable =
        source.signUp(param.toSignUpRequest())

    class SignUpParam(
        val email: String,
        val password: String,
        val firstName: String,
        val lastName: String,
        val oib: String,
        val dob: String,
        val phoneNumber: String,
        val mbo: String?,
        val ordinationName: String?,
        val address: String?,
        val workingHours: String?,
        val isUserDoctor: Boolean
    ) {

        fun toSignUpRequest(): SignUpRequest =
            SignUpRequest(
                email, password, firstName, lastName, phoneNumber, oib, dob, mbo, address, ordinationName, workingHours, isUserDoctor
            )
    }
}
