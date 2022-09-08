package com.mediconear.patientdoctorsignup.di

import com.mediconear.patientdoctorsignup.service.PatientDoctorSignUpService
import com.mediconear.patientdoctorsignup.source.PatientDoctorSignUpSource
import com.mediconear.patientdoctorsignup.source.PatientDoctorSignUpSourceImpl
import com.mediconear.patientdoctorsignup.usecase.QueryDoctorsForPatient
import com.mediconear.patientdoctorsignup.usecase.QueryPatientsForDoctor
import com.mediconear.patientdoctorsignup.usecase.SignUpPatientToDoctor
import com.mediconear.sessionlib.di.RETROFIT_WITH_AUTH
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

fun patientDoctorSignUpModule(): Module = module {

    single { SignUpPatientToDoctor(get()) }

    single { QueryDoctorsForPatient(get()) }

    single { QueryPatientsForDoctor(get()) }

    single<PatientDoctorSignUpSource> { PatientDoctorSignUpSourceImpl(get()) }

    single { get<Retrofit>(named(RETROFIT_WITH_AUTH)).create(PatientDoctorSignUpService::class.java) }
}
