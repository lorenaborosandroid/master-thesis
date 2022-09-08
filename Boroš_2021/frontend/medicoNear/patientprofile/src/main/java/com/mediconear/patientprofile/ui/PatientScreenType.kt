package com.mediconear.patientprofile.ui

import java.io.Serializable

sealed class PatientScreenType: Serializable {
    object UserProfile : PatientScreenType()
    object PatientsProfile : PatientScreenType()
}
