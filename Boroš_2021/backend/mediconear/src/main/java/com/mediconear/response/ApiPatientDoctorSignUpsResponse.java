package com.mediconear.response;

import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Prijava;

import java.util.List;

public class ApiPatientDoctorSignUpsResponse {

    public ApiPatientDoctorSignUpsResponse(List<Prijava> signups) {
        this.signups = signups;
    }

    private List<Prijava> signups;

    public List<Prijava> getSignups() {
        return signups;
    }

    public void setSignups(List<Prijava> signups) {
        this.signups = signups;
    }
}
