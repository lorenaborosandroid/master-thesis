package com.mediconear.doctorprofile.ui

sealed class DoctorProfileViewState {

    data class DoctorConfiguration(
        val practiceName: String,
        val address: String,
        val name: String,
        val lastName: String,
        val workingHours: String,
        val oib: String,
        val dob: String,
        val email: String,
        val phoneNumber: String
    ): DoctorProfileViewState()
}
