package com.mediconear.biometricslib.usecase

import com.mediconear.biometricslib.biometrics.Biometrics
import com.mediconear.core.usecase.QueryUseCase
import io.reactivex.Flowable

/**
 * Checks whether is any biometric available or not
 */
class IsBiometricAvailable(private val biometrics: Biometrics) : QueryUseCase<Boolean> {

    override fun invoke(): Flowable<Boolean> = Flowable.fromCallable { biometrics.isBiometricAvailable() }
}
