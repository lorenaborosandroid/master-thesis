package com.mediconear.specializationtypelib.di

import com.mediconear.sessionlib.di.RETROFIT_WITH_AUTH
import com.mediconear.specializationtypelib.service.SpecializationTypeService
import com.mediconear.specializationtypelib.source.SpecializationTypeSource
import com.mediconear.specializationtypelib.source.SpecializationTypeSourceImpl
import com.mediconear.specializationtypelib.usecase.QuerySelectedSpecializationType
import com.mediconear.specializationtypelib.usecase.QuerySpecializationTypes
import com.mediconear.specializationtypelib.usecase.SetSelectedSpecializationType
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

fun specializationTypeLibModule(): Module = module {

    single { QuerySpecializationTypes(get()) }

    single { QuerySelectedSpecializationType(get()) }

    single { SetSelectedSpecializationType(get()) }

    single<SpecializationTypeSource> { SpecializationTypeSourceImpl(get()) }

    single { get<Retrofit>(named(RETROFIT_WITH_AUTH)).create(SpecializationTypeService::class.java) }
}
