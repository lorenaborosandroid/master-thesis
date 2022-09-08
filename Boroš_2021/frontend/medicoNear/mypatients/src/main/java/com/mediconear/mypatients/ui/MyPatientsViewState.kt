package com.mediconear.mypatients.ui

import com.mediconear.patientlib.model.Patient

sealed class MyPatientsViewState {

    data class Patients(val patients: List<Patient>) : MyPatientsViewState()
}
