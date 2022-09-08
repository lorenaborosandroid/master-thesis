package com.mediconear.sessionlib.usecase

import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.sessionlib.model.User
import com.mediconear.sessionlib.store.SessionStore
import io.reactivex.Flowable

class QueryUser(private val sessionStore: SessionStore): QueryUseCase<User> {

    override fun invoke(): Flowable<User> = Flowable.just(sessionStore.getUser())
}
