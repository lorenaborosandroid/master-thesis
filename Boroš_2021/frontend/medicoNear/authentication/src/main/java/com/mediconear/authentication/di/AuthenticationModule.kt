package com.mediconear.authentication.di

import com.mediconear.authentication.source.AuthenticationSource
import com.mediconear.authentication.source.AuthenticationSourceImpl
import com.mediconear.authentication.store.AuthenticationStore
import com.mediconear.authentication.store.AuthenticationStoreImpl
import com.mediconear.authentication.usecase.*
import com.mediconear.core.di.BACKGROUND_SCHEDULER
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun authenticationModule(): Module = module {

    single<AuthenticationSource> {
        AuthenticationSourceImpl(
            routingActionsDispatcher = get(),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER))
        )
    }

    single<AuthenticationStore> {
        AuthenticationStoreImpl(
            application = androidApplication(),
            sessionStore = get()
        )
    }

    single { Authenticate(get()) }

    single { AuthenticationHasSucceeded(get()) }

    single { AuthenticationHasFailed(get()) }

    single { WithAuthentication(get()) }

    single { SetUserPasscode(get()) }

    single { QueryUserPasscode(get()) }
}
