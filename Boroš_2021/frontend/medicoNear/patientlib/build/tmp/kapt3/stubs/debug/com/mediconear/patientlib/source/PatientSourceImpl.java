package com.mediconear.patientlib.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/mediconear/patientlib/source/PatientSourceImpl;", "Lcom/mediconear/patientlib/source/PatientSource;", "service", "Lcom/mediconear/patientlib/service/PatientService;", "(Lcom/mediconear/patientlib/service/PatientService;)V", "mapResponse", "Lio/reactivex/Flowable;", "Lcom/mediconear/patientlib/model/Patient;", "response", "Lcom/mediconear/patientlib/model/ApiPatientResponse;", "queryPatientById", "param", "", "Seed-0.1.0_debug"})
public final class PatientSourceImpl implements com.mediconear.patientlib.source.PatientSource {
    private final com.mediconear.patientlib.service.PatientService service = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<com.mediconear.patientlib.model.Patient> queryPatientById(int param) {
        return null;
    }
    
    private final io.reactivex.Flowable<com.mediconear.patientlib.model.Patient> mapResponse(com.mediconear.patientlib.model.ApiPatientResponse response) {
        return null;
    }
    
    public PatientSourceImpl(@org.jetbrains.annotations.NotNull()
    com.mediconear.patientlib.service.PatientService service) {
        super();
    }
}