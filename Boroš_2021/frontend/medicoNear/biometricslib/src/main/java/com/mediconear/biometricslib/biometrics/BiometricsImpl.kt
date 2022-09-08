package com.mediconear.biometricslib.biometrics

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class BiometricsImpl(private val context: Context) : Biometrics {

    private val biometricManager = BiometricManager.from(context)

    override fun isBiometricAvailable(): Boolean = biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS

    override fun getSupportedBiometricTypes(): List<String> {
        val supportedBiometricTypes = mutableListOf<String>()
        if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            supportedBiometricTypes.add(PackageManager.FEATURE_FINGERPRINT)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_FACE)) {
                supportedBiometricTypes.add(PackageManager.FEATURE_FACE)
            }
        }

        return supportedBiometricTypes
    }

    override fun isBiometricsHardwareDetected(): Boolean =
        biometricManager.canAuthenticate() != BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE

    override fun authenticate(
        fragment: Fragment,
        title: String,
        negativeButtonText: String,
        onAuthenticationSuccess: () -> Unit,
        onAuthenticationError: () -> Unit
    ) {
        val authenticationCallback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onAuthenticationSuccess()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onAuthenticationError()
            }
        }
        val biometricPrompt = BiometricPrompt(
            fragment,
            ContextCompat.getMainExecutor(context),
            authenticationCallback
        )

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setNegativeButtonText(negativeButtonText)
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}
