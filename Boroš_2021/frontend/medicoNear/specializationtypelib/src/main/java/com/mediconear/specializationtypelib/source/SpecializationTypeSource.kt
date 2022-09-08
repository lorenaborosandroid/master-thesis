package com.mediconear.specializationtypelib.source

import com.mediconear.specializationtypelib.model.SpecializationType
import io.reactivex.Completable
import io.reactivex.Flowable

interface SpecializationTypeSource {

    fun querySpecializationTypes(): Flowable<List<SpecializationType>>

    fun setSelectedSpecializationType(type: SpecializationType): Completable

    fun querySelectedSpecializationType(): Flowable<SpecializationType>
}
