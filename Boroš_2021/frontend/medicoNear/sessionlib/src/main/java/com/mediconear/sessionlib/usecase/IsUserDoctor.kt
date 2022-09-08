package com.mediconear.sessionlib.usecase

import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.sessionlib.store.SessionStore
import io.reactivex.Flowable

class IsUserDoctor(private val store: SessionStore): QueryUseCase<Boolean> {

    override fun invoke(): Flowable<Boolean> = Flowable.just(store.isUserDoctor())
}
