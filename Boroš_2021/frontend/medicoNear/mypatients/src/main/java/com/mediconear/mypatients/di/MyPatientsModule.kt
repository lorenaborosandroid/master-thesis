package com.mediconear.mypatients.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.mypatients.ui.MyPatientsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun myPatientsModule(): Module = module {

    viewModel {
        MyPatientsViewModel(
            queryDoctor = get(),
            withAuthentication = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            queryPatientsForDoctor = get()
        )
    }
}
