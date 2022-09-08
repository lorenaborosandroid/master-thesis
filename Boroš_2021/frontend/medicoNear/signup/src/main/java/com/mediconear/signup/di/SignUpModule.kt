package com.mediconear.signup.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.signup.ui.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun signUpModule(): Module = module {

    viewModel {(isUserDoctor: Boolean) ->
        SignUpViewModel(
            isUserDoctor,
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            signUp = get(),
            signIn = get()
        )
    }
}
