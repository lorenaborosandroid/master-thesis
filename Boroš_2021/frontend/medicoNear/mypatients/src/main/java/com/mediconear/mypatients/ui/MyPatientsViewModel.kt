package com.mediconear.mypatients.ui

import com.mediconear.authentication.usecase.WithAuthentication
import com.mediconear.coreui.BaseViewModel
import com.mediconear.doctorslib.usecase.QueryDoctor
import com.mediconear.mypatients.ui.MyPatientsViewState.Patients
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import com.mediconear.patientlib.model.Patient
import com.mediconear.patientdoctorsignup.usecase.QueryPatientsForDoctor
import io.reactivex.Completable
import io.reactivex.Scheduler

class MyPatientsViewModel(
    private val queryPatientsForDoctor: QueryPatientsForDoctor,
    private val withAuthentication: WithAuthentication,
    queryDoctor: QueryDoctor,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<MyPatientsViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    init {
        query(
            queryDoctor()
                .switchMap {
                    queryPatientsForDoctor(it.doctorId)
                        .map(::toPatients)
                }

        )
    }

    fun patientSelected(patient: Patient) = runCommand(
        withAuthentication(
            Completable.fromAction {
                dispatchRoutingAction { router -> router.showPatientDetails(patient.user.userId) }
            }
        )
    )

    private fun toPatients(list: List<PatientDoctorSignUp>) : Patients {
        val viewState = mutableListOf<Patient>()
        list.forEach {
            viewState.add(it.patient)
        }

        return Patients(viewState)
    }
}
