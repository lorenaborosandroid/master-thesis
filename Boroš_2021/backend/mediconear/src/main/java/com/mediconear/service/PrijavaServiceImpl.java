package com.mediconear.service;

import com.mediconear.domain.Prijava;
import com.mediconear.repository.PrijavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrijavaServiceImpl implements PrijavaService {

    @Autowired
    private PrijavaRepository repository;

    @Override
    public List<Prijava> findAll(){
        return repository.findAll();
    }

    @Override
    public Prijava createPrijava(Prijava prijava) {
        return repository.save(prijava);
    }
}
