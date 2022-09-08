package com.mediconear.dashboard.di

import androidx.fragment.app.Fragment
import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.dashboard.ui.DashboardAdapter
import com.mediconear.dashboard.ui.DashboardViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun dashboardModule(): Module = module {

    factory {
        val fragment: Fragment = it[0]
        DashboardAdapter(fragment)
    }

    viewModel {
        DashboardViewModel(
            signOut = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            isUserDoctor = get(),
            queryUser = get()
        )
    }
}
