package com.mediconear.specializationtypelib.usecase

import com.mediconear.core.usecase.CommandUseCaseWithParam
import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypelib.source.SpecializationTypeSource
import io.reactivex.Completable

class SetSelectedSpecializationType(private val source: SpecializationTypeSource): CommandUseCaseWithParam<SpecializationType> {

    override fun invoke(param: SpecializationType): Completable =
        source.setSelectedSpecializationType(param)
}