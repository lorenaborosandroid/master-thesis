package com.mediconear.doctorprofile.di

import com.mediconear.core.di.BACKGROUND_SCHEDULER
import com.mediconear.core.di.MAIN_SCHEDULER
import com.mediconear.doctorprofile.ui.DoctorProfileViewModel
import com.mediconear.doctorprofile.ui.DoctorScreenType
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun doctorProfileModule(): Module = module {

    viewModel { (screenType: DoctorScreenType, doctorId: Int) ->
        DoctorProfileViewModel(
            screenType = screenType,
            doctorId = doctorId,
            queryDoctorById = get(),
            updateDoctor = get(),
            mainThreadScheduler = get(named(MAIN_SCHEDULER)),
            backgroundScheduler = get(named(BACKGROUND_SCHEDULER)),
            routingActionsDispatcher = get(),
            queryUser = get(),
            queryPatientById = get(),
            signUpPatientToDoctor = get()
        )
    }
}
