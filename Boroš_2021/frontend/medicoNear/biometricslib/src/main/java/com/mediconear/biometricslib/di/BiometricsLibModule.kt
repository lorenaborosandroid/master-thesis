package com.mediconear.biometricslib.di

import com.mediconear.biometricslib.biometrics.Biometrics
import com.mediconear.biometricslib.biometrics.BiometricsImpl
import com.mediconear.biometricslib.usecase.IsBiometricAvailable
import com.mediconear.biometricslib.usecase.IsBiometricsHardwareDetected
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

fun biometricLibModule(): Module = module {

    single<Biometrics> { BiometricsImpl(androidContext()) }

    single { IsBiometricAvailable(get()) }

    single { IsBiometricsHardwareDetected(get()) }
}
