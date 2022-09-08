package com.mediconear.doctorprofile.ui

import com.mediconear.coreui.BaseViewModel
import com.mediconear.doctorprofile.ui.DoctorProfileViewState.DoctorConfiguration
import com.mediconear.doctorslib.usecase.QueryDoctorById
import com.mediconear.doctorslib.usecase.UpdateDoctor
import com.mediconear.navigation.RoutingActionsDispatcher
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import com.mediconear.patientdoctorsignup.usecase.SignUpPatientToDoctor
import com.mediconear.patientlib.usecase.QueryPatientById
import com.mediconear.sessionlib.usecase.QueryUser
import io.reactivex.Scheduler

class DoctorProfileViewModel(
    private val screenType: DoctorScreenType,
    private val doctorId: Int,
    private val queryDoctorById: QueryDoctorById,
    private val updateDoctor: UpdateDoctor,
    private val queryPatientById: QueryPatientById,
    private val queryUser: QueryUser,
    private val signUpPatientToDoctor: SignUpPatientToDoctor,
    mainThreadScheduler: Scheduler,
    backgroundScheduler: Scheduler,
    routingActionsDispatcher: RoutingActionsDispatcher
) : BaseViewModel<DoctorProfileViewState>(
    mainThreadScheduler,
    backgroundScheduler,
    routingActionsDispatcher
) {

    init {

        query(
            queryDoctorById(doctorId)
                .map {
                    DoctorConfiguration(
                        it.practiceName, it.address, it.user.firstName,
                        it.user.lastName, it.workingHours, it.user.oib, it.user.dob, it.user.email, it.user.phoneNumber
                    )
                }
        )
    }

    fun signUpPatientToDoctor() {
        runCommand(
            queryDoctorById(doctorId)
                .firstOrError()
                .flatMapCompletable { doctor ->
                    queryUser()
                        .firstOrError()
                        .flatMapCompletable { user ->
                            queryPatientById(user.userId)
                                .firstOrError()
                                .flatMapCompletable { patient ->
                                    signUpPatientToDoctor(
                                        PatientDoctorSignUp(
                                            doctor,
                                            patient,
                                            doctor.specializationType
                                        )
                                    ).doOnComplete { goBack() }
                                }
                        }
                }
        )
    }

    fun updateDoctorInformation(
        email: String, phoneNumber: String, practiceName: String,
        workingHours: String, address: String, firstName: String, lastName: String, oib: String, dob: String
    ) {
        //        val doctor = Doctor(
        //            doctorId = doctorId,
        //            practiceName = practiceName,
        //            address = address,
        //            user = User(firstName = firstName, lastName = lastName, oib = oib, dob = dob, phoneNumber = phoneNumber, userId = 0),
        //            workingHours = workingHours,
        //            specializationType = com.mediconear.specializationtypelib.model.SpecializationType.Companion.EMPTY
        //        )
        //
        //        runCommand(updateDoctor(doctor)
        //            .doOnComplete { goBack() })
    }

    private fun goBack() {
        dispatchRoutingAction { router -> router.goBack() }
    }
}
