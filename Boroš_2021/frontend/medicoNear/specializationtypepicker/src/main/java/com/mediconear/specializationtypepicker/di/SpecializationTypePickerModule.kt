package com.mediconear.specializationtypepicker.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.specializationtypepicker.ui.SpecializationTypePickerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun specializationTypePickerModule(): Module = module {

    viewModel {(isFromOnBoarding: Boolean) ->
        SpecializationTypePickerViewModel(
            isFromOnBoarding = isFromOnBoarding,
            querySpecializationTypes = get(),
            setSelectedSpecializationType = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            updateDoctor = get(),
            queryDoctor = get()
        )
    }
}
