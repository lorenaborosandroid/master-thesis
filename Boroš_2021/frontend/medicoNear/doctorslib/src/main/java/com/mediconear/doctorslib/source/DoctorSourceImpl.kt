package com.mediconear.doctorslib.source

import com.mediconear.doctorslib.model.ApiDoctorResponse
import com.mediconear.doctorslib.model.Doctor
import com.mediconear.doctorslib.model.DoctorRequest
import com.mediconear.doctorslib.service.DoctorService
import com.mediconear.specializationtypelib.model.SpecializationType
import io.reactivex.Completable
import io.reactivex.Flowable

class DoctorSourceImpl(private val service: DoctorService) : DoctorSource {

    override fun queryAllDoctors(): Flowable<List<Doctor>> =
        service.getDoctors().map { it.doctors }.map { it.map { apiDoctorResponse -> mapToDoctor(apiDoctorResponse) } }

    override fun queryDoctorsBySpecializationType(specializationType: Int): Flowable<List<Doctor>> =
        service.getDoctorsBySpecializationType(specializationType)
            .map { it.doctors }.map { it.map { apiDoctorResponse -> mapToDoctor(apiDoctorResponse) } }

    override fun queryDoctorById(id: Int): Flowable<Doctor> =
        service.queryDoctorById(id)
            .switchMap(::mapResponse)

    private fun mapResponse(response: ApiDoctorResponse): Flowable<Doctor> {
        return Flowable.just(
            Doctor(
                doctorId = response.doctorId,
                practiceName = response.practiceName,
                workingHours = response.workingHours,
                address = response.address,
                specializationType = response.specializationType ?: SpecializationType.EMPTY,
                user = response.user
            )
        )
    }

    override fun updateDoctor(doctor: Doctor): Completable =
        service.updateDoctor(mapToDoctorRequest(doctor))
            .flatMapCompletable { Completable.complete() }

    private fun mapToDoctorRequest(doctor: Doctor) = with(doctor) {
        DoctorRequest(
            doctorId = doctorId,
            practiceName = practiceName,
            address = address,
            workingHours = workingHours,
            specializationType = specializationType,
            user = user
        )
    }

    private fun mapToDoctor(apiDoctor: ApiDoctorResponse): Doctor {
        return Doctor(
            doctorId = apiDoctor.doctorId,
            workingHours = apiDoctor.workingHours,
            address = apiDoctor.address,
            specializationType = apiDoctor.specializationType ?: SpecializationType.EMPTY,
            practiceName = apiDoctor.practiceName,
            user = apiDoctor.user
        )
    }
}
