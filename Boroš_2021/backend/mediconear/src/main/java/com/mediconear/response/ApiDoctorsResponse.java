package com.mediconear.response;

import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Specijalnost;

import java.util.List;

public class ApiDoctorsResponse {

    public ApiDoctorsResponse(List<Lijecnik> doctors) {
        this.doctors = doctors;
    }

    private List<Lijecnik> doctors;

    public List<Lijecnik> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Lijecnik> doctors) {
        this.doctors = doctors;
    }
}
