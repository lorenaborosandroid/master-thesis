package com.mediconear.authentication.usecase

import com.mediconear.authentication.store.AuthenticationStore
import com.mediconear.core.usecase.QueryUseCase
import io.reactivex.Flowable

class QueryUserPasscode(private val store: AuthenticationStore) : QueryUseCase<String> {

    override fun invoke(): Flowable<String> = Flowable.just(
        store.getUserPasscode()
    )
}
