package com.mediconear.patientlib.source

import com.mediconear.patientlib.model.Patient
import io.reactivex.Flowable

interface PatientSource {

    fun queryPatientById(param: Int): Flowable<Patient>
}
