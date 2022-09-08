package com.mediconear.service;

import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Pacijent;
import com.mediconear.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacijentServiceImpl implements PacijentService {

    @Autowired
    private PacijentRepository repository;

    @Override
    public List<Pacijent> findAll() {
        return repository.findAll();
    }

    @Override
    public Pacijent getPatientById(Long patientId) {
        return repository.getPatientById(patientId);
    }
}
