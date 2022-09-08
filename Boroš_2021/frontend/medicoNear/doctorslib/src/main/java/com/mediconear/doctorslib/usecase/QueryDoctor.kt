package com.mediconear.doctorslib.usecase

import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.sessionlib.store.SessionStore
import io.reactivex.Flowable

class QueryDoctor(private val queryDoctorById: QueryDoctorById, private val store: SessionStore): QueryUseCase<Doctor> {

    override fun invoke(): Flowable<Doctor> =
        queryDoctorById(store.getUser().userId)
}
