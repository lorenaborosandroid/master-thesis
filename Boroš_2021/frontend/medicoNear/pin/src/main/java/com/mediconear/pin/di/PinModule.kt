package com.mediconear.pin.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.pin.ui.PinViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun pinModule(): Module = module {

    viewModel { (isFromOnBoarding: Boolean) ->
        PinViewModel(
            isFromOnBoarding = isFromOnBoarding,
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            setUserPasscode = get(),
            authenticationHasFailed = get(),
            authenticationHasSucceeded = get(),
            queryUserPasscode = get(),
            isBiometricAvailable = get(),
            biometrics = get()
        )
    }
}
