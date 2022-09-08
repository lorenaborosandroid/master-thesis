package com.mediconear.core.usecase

import io.reactivex.Completable

interface CommandUseCaseWithParam<Param> {

    operator fun invoke(param: Param): Completable
}
