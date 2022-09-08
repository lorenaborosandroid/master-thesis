package com.mediconear.patientprofile.ui

import com.mediconear.sessionlib.model.User

sealed class PatientProfileViewState {

    data class PatientConfiguration(
        val patientId: Int,
        val mbo: String,
        val user: User
    ): PatientProfileViewState()
}
