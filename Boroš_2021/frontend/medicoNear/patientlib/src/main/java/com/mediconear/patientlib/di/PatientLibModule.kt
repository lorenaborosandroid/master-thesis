package com.mediconear.patientlib.di

import com.mediconear.patientlib.service.PatientService
import com.mediconear.patientlib.source.PatientSource
import com.mediconear.patientlib.source.PatientSourceImpl
import com.mediconear.patientlib.usecase.QueryPatient
import com.mediconear.patientlib.usecase.QueryPatientById
import com.mediconear.sessionlib.di.RETROFIT_WITH_AUTH
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

fun patientLibModule(): Module = module {

    single { QueryPatientById(source = get()) }

    single { QueryPatient(get(), get()) }

    single { get<Retrofit>(named(RETROFIT_WITH_AUTH)).create(PatientService::class.java) }

    single<PatientSource> { PatientSourceImpl(service = get()) }
}
