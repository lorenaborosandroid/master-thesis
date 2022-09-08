package com.mediconear.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.mediconear.R
import com.mediconear.dashboard.ui.DashboardFragment
import com.mediconear.doctorprofile.ui.DoctorProfileFragment
import com.mediconear.landing.ui.LandingFragment
import com.mediconear.main.MainActivity
import com.mediconear.patientprofile.ui.PatientProfileFragment
import com.mediconear.pin.ui.PinFragment
import com.mediconear.signin.ui.SignInFragment
import com.mediconear.signup.ui.SignUpFragment
import com.mediconear.specializationtypepicker.ui.SpecializationTypePickerFragment
import com.mediconear.start.StartActivity
import com.mediconear.userrole.ui.UserRoleFragment

private const val LAST_FRAGMENT = 0

@IdRes
private const val START_FLOW_CONTAINER = R.id.activity_start_container

@IdRes
private const val MAIN_FLOW_CONTAINER = R.id.activity_main_container

class RouterImpl(
    private val activity: AppCompatActivity,
    fragmentManager: FragmentManager,
    closeableRouterContext: CloseableRouterContext
) : CloseableRouter(fragmentManager, closeableRouterContext), Router {

    override fun showLandingScreen() {
        fragmentManager.inTransaction {
            add(START_FLOW_CONTAINER, LandingFragment(), LandingFragment.TAG)
        }
    }

    override fun clearAll() = fragmentManager.safeClearBackStack()

    override fun goBack() = dispatchOnMainThreadWithThrottle(this::goBackInternal)

    private fun goBackInternal() {
        if (!propagateBackToTopFragment(fragmentManager)) {
            if (fragmentManager.backStackEntryCount != LAST_FRAGMENT) {
                fragmentManager.popBackStackImmediate()
            } else {
                finishHostActivity()
            }
        }
    }

    override fun finishHostActivity() {
        activity.finish()
    }

    override fun showSignInScreen() = dispatchOnMainThreadWithThrottle {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(START_FLOW_CONTAINER, SignInFragment.newInstance(), PinFragment.TAG)
        }
    }

    override fun showSignUpScreen(isUserDoctor: Boolean) = dispatchOnMainThreadWithThrottle {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(START_FLOW_CONTAINER, SignUpFragment.newInstance(isUserDoctor), SignUpFragment.TAG)
        }
    }

    override fun startMainActivity() {
        activity.run {
            startActivity(MainActivity.createIntent(this))
            finish()
        }
    }

    override fun showDashboardScreen() = dispatchOnMainThreadWithThrottle {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(MAIN_FLOW_CONTAINER, DashboardFragment.newInstance(), DashboardFragment.TAG)
        }
    }

    override fun showUserRoleSelectionScreen() {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(START_FLOW_CONTAINER, UserRoleFragment.newInstance(), UserRoleFragment.TAG)
        }
    }

    override fun showSelectionTypePicker(isFromOnBoarding: Boolean) {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(
                if (!isFromOnBoarding) MAIN_FLOW_CONTAINER else START_FLOW_CONTAINER,
                SpecializationTypePickerFragment.newInstance(isFromOnBoarding),
                SpecializationTypePickerFragment.TAG
            )
        }
    }

    override fun showDoctorDetails(doctorId: Int) {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(MAIN_FLOW_CONTAINER, DoctorProfileFragment.newInstanceForDoctorsProfile(doctorId), DoctorProfileFragment.TAG)
        }
    }

    override fun showPatientDetails(patient: Int) {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(MAIN_FLOW_CONTAINER, PatientProfileFragment.newInstanceForPatientsProfile(patient), PatientProfileFragment.TAG)
        }
    }

    override fun showUserProfile(isUserDoctor: Boolean, userId: Int) {
        if (isUserDoctor) {
            fragmentManager.inTransactionAndAddToBackStack {
                applySlideInEnterSlideOutExitAnimation()
                add(MAIN_FLOW_CONTAINER, DoctorProfileFragment.newInstanceForUser(userId), DoctorProfileFragment.TAG)
            }
        } else {
            fragmentManager.inTransactionAndAddToBackStack {
                applySlideInEnterSlideOutExitAnimation()
                add(MAIN_FLOW_CONTAINER, PatientProfileFragment.newInstanceForUser(userId), PatientProfileFragment.TAG)
            }
        }
    }

    override fun showPinScreen(isFromOnBoarding: Boolean) {
        fragmentManager.inTransactionAndAddToBackStack {
            applySlideInEnterSlideOutExitAnimation()
            add(if (isFromOnBoarding) START_FLOW_CONTAINER else MAIN_FLOW_CONTAINER, PinFragment.newInstance(isFromOnBoarding), PinFragment.TAG)
        }
    }

    override fun removeRequestAuthenticationScreen() {
        markForClosing(PinFragment.TAG)
    }

    override fun showStartActivity() = activity.run {
        startActivity(StartActivity.createIntent(this, true))
        finishAffinity()
    }
}
