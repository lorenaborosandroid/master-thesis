package com.mediconear.patientdoctorsignup.source

import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import io.reactivex.Completable
import io.reactivex.Flowable

interface PatientDoctorSignUpSource {

    fun queryPatientDoctorSignUps(): Flowable<List<PatientDoctorSignUp>>

    fun signUpPatientToDoctor(param: PatientDoctorSignUp): Completable

    fun queryPatientsForDoctor(doctorId: Int): Flowable<List<PatientDoctorSignUp>>

    fun queryDoctorsForPatient(patientId: Int): Flowable<List<PatientDoctorSignUp>>
}
