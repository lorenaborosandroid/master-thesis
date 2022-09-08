package com.mediconear.service;

import com.mediconear.domain.Korisnik;

import java.util.Optional;

public interface KorisnikService {

    Optional<Korisnik> findById(Long korisnik_id);

    Optional<Korisnik> findByEmail(String email);

    void updateKorisnik(String ime, String prezime, String kontaktni_broj, String email, String oib, String
                        datum_rodjenja, Long korisnik_id);
}
