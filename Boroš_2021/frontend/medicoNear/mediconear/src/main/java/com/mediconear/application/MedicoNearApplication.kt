package com.mediconear.application

import android.app.Application
import com.coinme.commonui.di.commonUiModule
import com.mediconear.authentication.di.authenticationModule
import com.mediconear.biometricslib.di.biometricLibModule
import com.mediconear.core.appconfig.CrashlyticsAppConfig
import com.mediconear.core.appconfig.RxJavaErrorHandlingAppConfig
import com.mediconear.core.appconfig.TimberAppConfig
import com.mediconear.core.di.threadingModule
import com.mediconear.dashboard.di.dashboardModule
import com.mediconear.di.appModule
import com.mediconear.doctorprofile.di.doctorProfileModule
import com.mediconear.doctorslib.di.doctorsLibModule
import com.mediconear.landing.di.landingModule
import com.mediconear.mydoctors.di.myDoctorsModule
import com.mediconear.mypatients.di.myPatientsModule
import com.mediconear.navigation.navigationModule
import com.mediconear.patientdoctorsignup.di.patientDoctorSignUpModule
import com.mediconear.patientlib.di.patientLibModule
import com.mediconear.patientprofile.di.patientProfileModule
import com.mediconear.pin.di.pinModule
import com.mediconear.search.di.searchModule
import com.mediconear.sessionlib.di.sessionLibModule
import com.mediconear.signin.di.signInModule
import com.mediconear.signup.di.signUpModule
import com.mediconear.specializationtypelib.di.specializationTypeLibModule
import com.mediconear.specializationtypepicker.di.specializationTypePickerModule
import com.mediconear.userrole.di.userRoleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MedicoNearApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()

        TimberAppConfig().configure()
        CrashlyticsAppConfig().configure()
        RxJavaErrorHandlingAppConfig().configure()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MedicoNearApplication)
            modules(
                listOf(
                    appModule(),
                    commonUiModule(),
                    threadingModule(),
                    navigationModule(),
                    landingModule(),
                    signInModule(),
                    signUpModule(),
                    searchModule(),
                    myPatientsModule(),
                    myDoctorsModule(),
                    doctorProfileModule(),
                    patientProfileModule(),
                    dashboardModule(),
                    userRoleModule(),
                    doctorsLibModule(),
                    specializationTypeLibModule(),
                    specializationTypePickerModule(),
                    patientLibModule(),
                    pinModule(),
                    biometricLibModule(),
                    authenticationModule(),
                    sessionLibModule(),
                    patientDoctorSignUpModule()
                )
            )
        }
    }

}
