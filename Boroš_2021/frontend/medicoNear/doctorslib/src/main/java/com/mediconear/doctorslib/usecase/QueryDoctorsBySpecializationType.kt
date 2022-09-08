package com.mediconear.doctorslib.usecase

import com.mediconear.core.usecase.QueryUseCaseWithParam
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.source.DoctorSource
import io.reactivex.Flowable

class QueryDoctorsBySpecializationType(private val source: DoctorSource) : QueryUseCaseWithParam<Int, List<Doctor>> {

    override fun invoke(param: Int): Flowable<List<Doctor>> =
        source.queryDoctorsBySpecializationType(param)
}
