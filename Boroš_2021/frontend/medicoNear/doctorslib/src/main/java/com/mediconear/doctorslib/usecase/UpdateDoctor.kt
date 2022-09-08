package com.mediconear.doctorslib.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.source.DoctorSource
import io.reactivex.Completable

class UpdateDoctor(private val source: DoctorSource): CommandUseCaseWithParam<Doctor> {

    override fun invoke(param: Doctor): Completable =
        source.updateDoctor(param)
}