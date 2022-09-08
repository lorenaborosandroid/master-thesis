package com.mediconear.biometricslib.biometrics

import androidx.fragment.app.Fragment

interface Biometrics {

    fun isBiometricAvailable(): Boolean

    fun getSupportedBiometricTypes(): List<String>

    fun isBiometricsHardwareDetected(): Boolean

    fun authenticate(
        fragment: Fragment,
        title: String,
        negativeButtonText: String,
        onAuthenticationSuccess: () -> Unit,
        onAuthenticationError: () -> Unit
    )
}
