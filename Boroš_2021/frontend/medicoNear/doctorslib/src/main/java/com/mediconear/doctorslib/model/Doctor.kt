package com.mediconear.doctorslib.model

import com.mediconear.coreui.utils.DiffUtilViewModel
import com.mediconear.sessionlib.model.User
import com.mediconear.specializationtypelib.model.SpecializationType

data class Doctor(
    val doctorId: Int,
    val practiceName: String,
    val specializationType: SpecializationType,
    val address: String,
    val workingHours: String,
    val user: User
) : DiffUtilViewModel(doctorId) {

    fun toRequest(): DoctorRequest =
        DoctorRequest(
            doctorId, practiceName, specializationType, address, workingHours, user
        )
}
