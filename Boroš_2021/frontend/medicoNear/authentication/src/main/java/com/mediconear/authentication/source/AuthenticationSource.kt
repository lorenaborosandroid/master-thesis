package com.mediconear.authentication.source

import io.reactivex.Completable

interface AuthenticationSource {

    fun authenticate(): Completable

    fun currentAuthenticationHasSucceeded(): Completable

    fun currentAuthenticationHasFailed(): Completable
}
