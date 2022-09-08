package com.mediconear.service;

import com.mediconear.domain.Specijalnost;
import com.mediconear.repository.SpecijalizacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecijalizacijaServiceImpl implements SpecijalizacijaService {

    @Autowired
    private SpecijalizacijaRepository repository;

    @Override
    public List<Specijalnost> findAll() {
        return repository.findAll();
    }
}
