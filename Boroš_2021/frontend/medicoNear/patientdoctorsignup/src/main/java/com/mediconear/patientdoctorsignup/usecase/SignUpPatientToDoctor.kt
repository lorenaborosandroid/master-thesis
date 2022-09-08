package com.mediconear.patientdoctorsignup.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import com.mediconear.patientdoctorsignup.source.PatientDoctorSignUpSource
import io.reactivex.Completable

class SignUpPatientToDoctor(private val source: PatientDoctorSignUpSource) : CommandUseCaseWithParam<PatientDoctorSignUp> {

    override fun invoke(param: PatientDoctorSignUp): Completable =
        source.signUpPatientToDoctor(param)
}
