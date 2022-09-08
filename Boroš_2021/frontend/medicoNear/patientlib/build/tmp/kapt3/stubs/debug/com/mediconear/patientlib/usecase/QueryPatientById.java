package com.mediconear.patientlib.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/mediconear/patientlib/usecase/QueryPatientById;", "Lcom/mediconear/core/usecase/QueryUseCaseWithParam;", "", "Lcom/mediconear/patientlib/model/Patient;", "source", "Lcom/mediconear/patientlib/source/PatientSource;", "(Lcom/mediconear/patientlib/source/PatientSource;)V", "invoke", "Lio/reactivex/Flowable;", "param", "Seed-0.1.0_debug"})
public final class QueryPatientById implements com.mediconear.core.usecase.QueryUseCaseWithParam<java.lang.Integer, com.mediconear.patientlib.model.Patient> {
    private final com.mediconear.patientlib.source.PatientSource source = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<com.mediconear.patientlib.model.Patient> invoke(int param) {
        return null;
    }
    
    public QueryPatientById(@org.jetbrains.annotations.NotNull()
    com.mediconear.patientlib.source.PatientSource source) {
        super();
    }
}