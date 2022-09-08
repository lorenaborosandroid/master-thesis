package com.mediconear.mydoctors.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.mydoctors.ui.MyDoctorsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun myDoctorsModule(): Module = module {

    viewModel {
        MyDoctorsViewModel(
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            queryDoctorsForPatient = get(),
            queryPatient = get()
        )
    }
}
