package com.mediconear.doctorslib.usecase

import com.mediconear.core.usecase.QueryUseCaseWithParam
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.source.DoctorSource
import io.reactivex.Flowable

class QueryDoctorById(private val source: DoctorSource) : QueryUseCaseWithParam<Int, Doctor> {

    override fun invoke(param: Int): Flowable<Doctor> =
        source.queryDoctorById(param)
}
