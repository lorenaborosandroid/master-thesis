package com.mediconear.patientprofile.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.patientprofile.ui.PatientProfileViewModel
import com.mediconear.patientprofile.ui.PatientScreenType
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun patientProfileModule(): Module = module {

    viewModel { (screenType: PatientScreenType, userId: Int) ->
        PatientProfileViewModel(
            screenType = screenType,
            userId = userId,
            queryPatientById = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get()
        )
    }
}
