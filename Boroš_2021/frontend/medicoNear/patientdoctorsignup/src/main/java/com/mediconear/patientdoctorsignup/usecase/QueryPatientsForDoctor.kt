package com.mediconear.patientdoctorsignup.usecase

import com.mediconear.core.usecase.QueryUseCaseWithParam
import com.mediconear.patientdoctorsignup.model.PatientDoctorSignUp
import com.mediconear.patientdoctorsignup.source.PatientDoctorSignUpSource
import io.reactivex.Flowable

class QueryPatientsForDoctor(private val source: PatientDoctorSignUpSource) : QueryUseCaseWithParam<Int, List<PatientDoctorSignUp>> {

    override fun invoke(param: Int): Flowable<List<PatientDoctorSignUp>> =
        source.queryPatientsForDoctor(param)
}
