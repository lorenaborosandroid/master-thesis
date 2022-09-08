package com.mediconear.doctorslib.source

import com.mediconear.doctorslib.model.Doctor
import io.reactivex.Completable
import io.reactivex.Flowable

interface DoctorSource {

    fun queryAllDoctors(): Flowable<List<Doctor>>

    fun updateDoctor(doctor: Doctor): Completable

    fun queryDoctorsBySpecializationType(specializationType: Int): Flowable<List<Doctor>>

    fun queryDoctorById(id: Int): Flowable<Doctor>
}
