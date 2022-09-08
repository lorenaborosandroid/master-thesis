package com.mediconear.service;

import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Pacijent;

import java.util.List;

public interface PacijentService {

    List<Pacijent> findAll();

    Pacijent getPatientById(Long patientId);
}
