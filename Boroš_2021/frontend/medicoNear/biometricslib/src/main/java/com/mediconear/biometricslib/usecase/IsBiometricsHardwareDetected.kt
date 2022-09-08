package com.mediconear.biometricslib.usecase

import com.mediconear.biometricslib.biometrics.Biometrics
import com.mediconear.core.usecase.QueryUseCase
import io.reactivex.Flowable

/**
 * Determine if fingerprint hardware is present and functional.
 *
 * @return true if hardware is present and functional, false otherwise.
 */
class IsBiometricsHardwareDetected(private val biometrics: Biometrics) : QueryUseCase<Boolean> {

    override fun invoke(): Flowable<Boolean> = Flowable.just(biometrics.isBiometricsHardwareDetected())
}
