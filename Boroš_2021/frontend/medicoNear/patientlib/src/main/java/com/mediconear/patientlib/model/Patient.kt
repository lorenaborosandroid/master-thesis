package com.mediconear.patientlib.model

import com.mediconear.coreui.utils.DiffUtilViewModel
import com.mediconear.sessionlib.model.User

data class Patient(
    val patientId: Int,
    val mbo: String,
    val user: User
): DiffUtilViewModel(patientId) {

    fun toRequest(): PatientRequest =
        PatientRequest(patientId, mbo, user)
}
