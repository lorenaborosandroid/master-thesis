package com.mediconear.patientdoctorsignup.model

import com.mediconear.doctorslib.model.Doctor
import com.mediconear.patientlib.model.Patient
import com.mediconear.specializationtypelib.model.SpecializationType

data class PatientDoctorSignUp(
    val doctor: Doctor,
    val patient: Patient,
    val specializationType: SpecializationType
)
