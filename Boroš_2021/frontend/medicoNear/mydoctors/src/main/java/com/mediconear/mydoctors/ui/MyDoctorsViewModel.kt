package com.mediconear.mydoctors.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.doctorslib.usecase.QueryDoctor
import com.mediconear.mydoctors.ui.MyDoctorsViewState.SpecializationDoctors
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import com.mediconear.patientdoctorsignup.usecase.QueryDoctorsForPatient
import com.mediconear.patientlib.usecase.QueryPatient
import io.reactivex.Scheduler

class MyDoctorsViewModel(
    private val queryDoctorsForPatient: QueryDoctorsForPatient,
    private val queryPatient: QueryPatient,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<MyDoctorsViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    init {
        query(
            queryPatient()
                .switchMap {
                    queryDoctorsForPatient(it.patientId)
                        .map(::toViewState)
                }

        )
    }

    private fun toViewState(list: List<PatientDoctorSignUp>): SpecializationDoctors {
        val viewStateList = mutableListOf<MyDoctorsItemViewState>()
        list
            .groupBy { it.specializationType }
            .entries
            .map { (specializationType, values) ->
                viewStateList.add(SpecializationItem(specializationType.typeId, specializationType.type))
                values.forEach { patientDoctorSignUp ->
                    viewStateList.add(
                        DoctorItem(
                            patientDoctorSignUp.doctor.user.userId, patientDoctorSignUp.doctor.practiceName,
                            patientDoctorSignUp.doctor.address
                        )
                    )
                }
            }

        return SpecializationDoctors(viewStateList)
    }

    fun showDoctorDetails(doctorId: Int) = dispatchRoutingAction { router -> router.showDoctorDetails(doctorId) }
}
