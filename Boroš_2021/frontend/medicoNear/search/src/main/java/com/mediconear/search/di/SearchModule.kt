package com.mediconear.search.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.search.ui.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun searchModule(): Module = module {

    viewModel {
        SearchViewModel(
            queryAllDoctors = get(),
            queryDoctorsBySpecializationType = get(),
            querySelectedSpecializationType = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get()
        )
    }
}
