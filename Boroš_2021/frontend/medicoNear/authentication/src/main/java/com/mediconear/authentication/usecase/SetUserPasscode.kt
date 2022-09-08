package com.mediconear.authentication.usecase

import com.mediconear.authentication.store.AuthenticationStore
import com.mediconear.core.usecase.CommandUseCaseWithParam
import io.reactivex.Completable

class SetUserPasscode(private val store: AuthenticationStore) : CommandUseCaseWithParam<String> {

    override fun invoke(param: String): Completable = Completable.fromAction {
        store.saveUserPasscode(param)
    }
}
