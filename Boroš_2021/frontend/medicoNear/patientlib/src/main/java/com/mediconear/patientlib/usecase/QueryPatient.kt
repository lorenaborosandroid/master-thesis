package com.mediconear.patientlib.usecase

import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.patientlib.model.Patient
import com.mediconear.sessionlib.store.SessionStore
import io.reactivex.Flowable

class QueryPatient(
    private val queryPatientById: QueryPatientById,
    private val store: SessionStore
) : QueryUseCase<Patient> {

    override fun invoke(): Flowable<Patient> = queryPatientById(store.getUser().userId)
}
