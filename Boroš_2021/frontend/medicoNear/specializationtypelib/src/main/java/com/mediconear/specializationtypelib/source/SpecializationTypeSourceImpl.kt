package com.mediconear.specializationtypelib.source

import com.mediconear.specializationtypelib.model.SpecializationType
import com.mediconear.specializationtypelib.service.SpecializationTypeService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor

class SpecializationTypeSourceImpl(private val service: SpecializationTypeService) : SpecializationTypeSource {

    private val processor: BehaviorProcessor<SpecializationType> = BehaviorProcessor.createDefault(SpecializationType.EMPTY)

    override fun querySpecializationTypes(): Flowable<List<SpecializationType>> =
        service.querySpecializationTypes().map { it.types }

    override fun querySelectedSpecializationType(): Flowable<SpecializationType> = processor

    override fun setSelectedSpecializationType(type: SpecializationType): Completable =
        Completable.fromAction { processor.onNext(type) }
}
