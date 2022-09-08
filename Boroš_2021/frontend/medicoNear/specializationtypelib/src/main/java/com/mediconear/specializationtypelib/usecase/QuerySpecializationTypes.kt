package com.mediconear.specializationtypelib.usecase

import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypelib.source.SpecializationTypeSource
import io.reactivex.Flowable

class QuerySpecializationTypes(private val specializationTypeSource: SpecializationTypeSource) : QueryUseCase<List<SpecializationType>> {

    override fun invoke(): Flowable<List<SpecializationType>> =
        specializationTypeSource.querySpecializationTypes()
}
