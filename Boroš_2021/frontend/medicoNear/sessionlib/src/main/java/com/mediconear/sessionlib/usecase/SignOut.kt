package com.mediconear.sessionlib.usecase

import com.mediconear.core.usecase.CommandUseCase
import com.mediconear.sessionlib.source.SessionSource
import io.reactivex.Completable

class SignOut(private val source: SessionSource) : CommandUseCase {

    override fun invoke(): Completable = source.signOut()
}
