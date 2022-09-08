package com.mediconear.service;

import com.mediconear.domain.Prijava;

import java.util.List;
import java.util.Optional;

public interface PrijavaService {

    List<Prijava> findAll();
    Prijava createPrijava(Prijava prijava);
}
