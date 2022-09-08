package com.mediconear.navigation

interface Router {

    fun showLandingScreen()

    fun finishHostActivity()

    fun clearAll()

    fun goBack()

    fun showSignInScreen()

    fun startMainActivity()

    fun showSignUpScreen(isUserDoctor: Boolean)

    fun showDashboardScreen()

    fun showUserRoleSelectionScreen()

    fun showSelectionTypePicker(isFromOnBoarding: Boolean)

    fun showDoctorDetails(doctorId: Int)

    fun showPatientDetails(patient: Int)

    fun showUserProfile(isUserDoctor: Boolean, userId: Int)

    fun showPinScreen(isFromOnBoarding: Boolean)

    fun removeRequestAuthenticationScreen()

    fun showStartActivity()
}
