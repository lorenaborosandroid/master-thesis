package com.mediconear.patientlib.usecase

import com.mediconear.core.usecase.QueryUseCaseWithParam
import com.mediconear.patientlib.model.Patient
import com.mediconear.patientlib.source.PatientSource
import io.reactivex.Flowable

class QueryPatientById(private val source: PatientSource): QueryUseCaseWithParam<Int, Patient> {

    override fun invoke(param: Int): Flowable<Patient> =
        source.queryPatientById(param)
}
