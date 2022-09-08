package com.mediconear.doctorslib.di

import com.mediconear.doctorslib.service.DoctorService
import com.mediconear.doctorslib.source.DoctorSource
import com.mediconear.doctorslib.source.DoctorSourceImpl
import com.mediconear.doctorslib.usecase.*
import com.mediconear.sessionlib.di.RETROFIT_WITH_AUTH
import com.mediconear.specializationtypelib.service.SpecializationTypeService
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

fun doctorsLibModule(): Module = module {

    single { QueryAllDoctors(get()) }

    single { QueryDoctorsBySpecializationType(get()) }

    single<DoctorSource> { DoctorSourceImpl(get()) }

    single { QueryDoctorById(get()) }

    single { UpdateDoctor(get()) }

    single { QueryDoctor(get(), get())}

    single { get<Retrofit>(named(RETROFIT_WITH_AUTH)).create(DoctorService::class.java) }
}
