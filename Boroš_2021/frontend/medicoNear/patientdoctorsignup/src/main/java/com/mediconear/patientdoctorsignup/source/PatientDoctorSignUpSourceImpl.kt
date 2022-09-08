package com.mediconear.patientdoctorsignup.source

import com.mediconear.coreui.shareReplayLatest
import com.mediconear.patientdoctorsignup.model.ApiPatientDoctorSignupResponse
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUpRequest
import com.mediconear.patientdoctorsignup.service.PatientDoctorSignUpService
import io.reactivex.Completable
import io.reactivex.Flowable

class PatientDoctorSignUpSourceImpl(private val service: PatientDoctorSignUpService) : PatientDoctorSignUpSource {

    private val patientDoctorSignUps = service.getPatientDoctorSignUp().map { it.signups }
        .map { it.map { signUpResponse -> mapToPatientDoctorSignUp(signUpResponse) } }
        .shareReplayLatest()

    override fun queryPatientDoctorSignUps(): Flowable<List<PatientDoctorSignUp>> = patientDoctorSignUps

    override fun signUpPatientToDoctor(param: PatientDoctorSignUp): Completable {
        val request = PatientDoctorSignUpRequest(
            param.doctor.toRequest(),
            param.patient.toRequest(),
            param.specializationType.toRequest()
        )
        return service.createPatientDoctorSignUp(request)
            .flatMapCompletable {
                Completable.complete()
            }
    }

    override fun queryPatientsForDoctor(doctorId: Int): Flowable<List<PatientDoctorSignUp>> =
        patientDoctorSignUps.map { list -> list.filter { it.doctor.doctorId == doctorId } }

    override fun queryDoctorsForPatient(patientId: Int): Flowable<List<PatientDoctorSignUp>> =
        patientDoctorSignUps.map { list -> list.filter { it.patient.patientId == patientId } }

    private fun mapToPatientDoctorSignUp(response: ApiPatientDoctorSignupResponse): PatientDoctorSignUp {
        with(response) {
            return PatientDoctorSignUp(
                doctor.toDoctor(),
                patient.toPatient(),
                specializationType
            )
        }
    }
}
