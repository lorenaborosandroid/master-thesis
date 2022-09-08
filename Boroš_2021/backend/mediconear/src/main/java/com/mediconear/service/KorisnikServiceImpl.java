package com.mediconear.service;

import com.mediconear.domain.Korisnik;
import com.mediconear.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository repository;

    @Override
    public Optional<Korisnik> findById(Long korisnik_id) {
        return repository.findById(korisnik_id);
    }

    @Override
    public Optional<Korisnik> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void updateKorisnik(String ime, String prezime, String kontaktni_broj, String email, String oib, String
            datum_rodjenja, Long korisnik_id) {
        repository.updateKorisnik(ime, prezime, kontaktni_broj, email, oib, datum_rodjenja, korisnik_id);
    }
}
