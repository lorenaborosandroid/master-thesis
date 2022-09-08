package com.mediconear.service;

import com.mediconear.domain.Lijecnik;
import com.mediconear.repository.LijecnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LijecnikServiceImpl implements LijecnikService {

    @Autowired
    private LijecnikRepository repository;

    @Autowired
    private KorisnikService korisnikService;

    @Override
    public List<Lijecnik> findAll(){
        return repository.findAll();
    }

    @Override
    public List<Lijecnik> getDoctorsForSpeciality(Long specijalizacijaId) {
        return repository.getDoctorsForSpeciality(specijalizacijaId);
    }

    @Override
    public Lijecnik getDoctorById(Long lijecnikId) {
        return repository.getDoctorById(lijecnikId);
    }

    @Override
    public void updateDoctor(Lijecnik lijecnik) {
        repository.updateDoctor(lijecnik.getLijecnik_id(), lijecnik.getAdresa(), lijecnik.getNaziv_ordinacije(),
                lijecnik.getRadno_vrijeme(), lijecnik.getSpecijalnost().getSpecijalnost_id());

        korisnikService.updateKorisnik(lijecnik.getKorisnik().getIme(), lijecnik.getKorisnik().getPrezime(),
                lijecnik.getKorisnik().getKontakt_broj(), lijecnik.getKorisnik().getEmail(), lijecnik.getKorisnik().getOib(),
                lijecnik.getKorisnik().getDatum_rodjenja(), lijecnik.getKorisnik().getKorisnik_id());
    }
}
