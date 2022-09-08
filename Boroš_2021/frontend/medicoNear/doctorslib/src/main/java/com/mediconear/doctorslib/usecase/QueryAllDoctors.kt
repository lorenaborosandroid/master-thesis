package com.mediconear.doctorslib.usecase

import android.util.Log
import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.source.DoctorSource
import io.reactivex.Flowable

class QueryAllDoctors(private val source: DoctorSource): QueryUseCase<List<Doctor>> {

    override fun invoke(): Flowable<List<Doctor>> = source.queryAllDoctors()
}
