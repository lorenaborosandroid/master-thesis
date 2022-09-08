package com.mediconear.patientlib.source

import com.mediconear.patientlib.model.ApiPatientResponse
import com.mediconear.patientlib.model.Patient
import com.mediconear.patientlib.service.PatientService
import io.reactivex.Flowable

class PatientSourceImpl(private val service: PatientService) : PatientSource {

    override fun queryPatientById(param: Int): Flowable<Patient> =
        service.queryPatientById(param)
            .switchMap(::mapResponse)

    private fun mapResponse(response: ApiPatientResponse): Flowable<Patient> {
        return Flowable.just(
            Patient(
                patientId = response.patientId,
                mbo = response.mbo,
                user = response.user
            )
        )
    }
}
