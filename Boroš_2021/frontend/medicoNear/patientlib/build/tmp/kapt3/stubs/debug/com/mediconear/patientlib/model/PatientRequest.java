package com.mediconear.patientlib.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/mediconear/patientlib/model/PatientRequest;", "", "patientId", "", "mbo", "", "user", "Lcom/mediconear/sessionlib/model/User;", "(ILjava/lang/String;Lcom/mediconear/sessionlib/model/User;)V", "getMbo", "()Ljava/lang/String;", "getPatientId", "()I", "getUser", "()Lcom/mediconear/sessionlib/model/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Seed-0.1.0_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class PatientRequest {
    private final int patientId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mbo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mediconear.sessionlib.model.User user = null;
    
    public final int getPatientId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMbo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mediconear.sessionlib.model.User getUser() {
        return null;
    }
    
    public PatientRequest(@com.squareup.moshi.Json(name = "pacijent_id")
    int patientId, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "mbo")
    java.lang.String mbo, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "korisnik")
    com.mediconear.sessionlib.model.User user) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mediconear.sessionlib.model.User component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mediconear.patientlib.model.PatientRequest copy(@com.squareup.moshi.Json(name = "pacijent_id")
    int patientId, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "mbo")
    java.lang.String mbo, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "korisnik")
    com.mediconear.sessionlib.model.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}