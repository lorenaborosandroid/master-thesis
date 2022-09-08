package com.mediconear.signin.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.signin.ui.SignInViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.math.sign

fun signInModule(): Module = module {

    viewModel {
        SignInViewModel(
            signIn = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get()
        )
    }
}
