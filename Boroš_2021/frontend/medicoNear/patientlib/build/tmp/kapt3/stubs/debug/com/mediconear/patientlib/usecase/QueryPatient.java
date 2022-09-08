package com.mediconear.patientlib.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/mediconear/patientlib/usecase/QueryPatient;", "Lcom/mediconear/core/usecase/QueryUseCase;", "Lcom/mediconear/patientlib/model/Patient;", "queryPatientById", "Lcom/mediconear/patientlib/usecase/QueryPatientById;", "store", "Lcom/mediconear/sessionlib/store/SessionStore;", "(Lcom/mediconear/patientlib/usecase/QueryPatientById;Lcom/mediconear/sessionlib/store/SessionStore;)V", "invoke", "Lio/reactivex/Flowable;", "Seed-0.1.0_debug"})
public final class QueryPatient implements com.mediconear.core.usecase.QueryUseCase<com.mediconear.patientlib.model.Patient> {
    private final com.mediconear.patientlib.usecase.QueryPatientById queryPatientById = null;
    private final com.mediconear.sessionlib.store.SessionStore store = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<com.mediconear.patientlib.model.Patient> invoke() {
        return null;
    }
    
    public QueryPatient(@org.jetbrains.annotations.NotNull()
    com.mediconear.patientlib.usecase.QueryPatientById queryPatientById, @org.jetbrains.annotations.NotNull()
    com.mediconear.sessionlib.store.SessionStore store) {
        super();
    }
}