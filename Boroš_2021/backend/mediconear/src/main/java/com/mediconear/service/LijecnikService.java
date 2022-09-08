package com.mediconear.service;

import com.mediconear.domain.Lijecnik;

import java.util.List;

public interface LijecnikService {

    List<Lijecnik> findAll();

    List<Lijecnik> getDoctorsForSpeciality(Long specijalizacijaId);

    Lijecnik getDoctorById(Long lijecnikId);

    void updateDoctor(Lijecnik lijecnik);
}
