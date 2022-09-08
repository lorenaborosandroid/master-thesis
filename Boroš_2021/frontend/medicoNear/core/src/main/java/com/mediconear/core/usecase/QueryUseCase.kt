package com.mediconear.core.usecase

import io.reactivex.Flowable

interface QueryUseCase<Result> {

    operator fun invoke(): Flowable<Result>
}
