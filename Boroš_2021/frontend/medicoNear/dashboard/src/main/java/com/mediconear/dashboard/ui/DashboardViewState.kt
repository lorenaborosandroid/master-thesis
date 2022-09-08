package com.mediconear.dashboard.ui

import com.mediconear.sessionlib.model.User

sealed class DashboardViewState {
    data class UserDoctorStatus(val isUserDoctor: Boolean) : DashboardViewState()
}
