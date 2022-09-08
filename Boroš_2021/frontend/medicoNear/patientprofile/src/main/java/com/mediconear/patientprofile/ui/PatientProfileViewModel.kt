package com.mediconear.patientprofile.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.patientlib.model.Patient
import com.mediconear.patientlib.usecase.QueryPatientById
import com.mediconear.patientprofile.ui.PatientProfileViewState.PatientConfiguration
import io.reactivex.Scheduler

class PatientProfileViewModel(
    private val screenType: PatientScreenType,
    private val userId: Int,
    private val queryPatientById: QueryPatientById,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<PatientProfileViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    init {
        query(
            queryPatientById(userId)
                .map(::toPatientConfiguration)
        )
    }

    fun updatePatientsInformation(
        email: String, phoneNumber: String, firstName: String, lastName: String,
        oib: String, dob: String, mbo: String
    ) {

    }

    private fun toPatientConfiguration(patient: Patient) = with(patient) {
        PatientConfiguration(
            patientId = patientId,
            mbo = mbo,
            user = user
        )
    }
}
