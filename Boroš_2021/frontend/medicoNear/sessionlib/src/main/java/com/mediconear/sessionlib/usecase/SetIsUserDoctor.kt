package com.mediconear.sessionlib.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import com.mediconear.sessionlib.store.SessionStore
import io.reactivex.Completable

class SetIsUserDoctor(private val store: SessionStore) : CommandUseCaseWithParam<Boolean> {

    override fun invoke(param: Boolean): Completable =
        Completable.fromAction { store.setIsUserDoctor(param) }
}
