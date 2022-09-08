package com.mediconear.specializationtypelib.usecase

import com.mediconear.core.usecase.QueryUseCase
import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypelib.source.SpecializationTypeSource
import io.reactivex.Flowable

class QuerySelectedSpecializationType(private val source: SpecializationTypeSource) : QueryUseCase<SpecializationType> {

    override fun invoke(): Flowable<SpecializationType> =
        source.querySelectedSpecializationType()
}
