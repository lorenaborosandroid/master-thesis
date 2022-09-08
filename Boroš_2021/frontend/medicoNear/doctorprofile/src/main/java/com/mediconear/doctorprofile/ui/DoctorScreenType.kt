package com.mediconear.doctorprofile.ui

import java.io.Serializable

sealed class DoctorScreenType: Serializable {
    object UserProfile : DoctorScreenType()
    object DoctorsProfile : DoctorScreenType()
}
