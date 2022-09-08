package com.mediconear.response;

import com.mediconear.domain.Korisnik;
import com.mediconear.domain.Specijalnost;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ApiDoctorResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lijecnik_id;

    @NotNull
    @NotBlank
    private String radno_vrijeme;

    @NotNull
    @NotBlank
    private String naziv_ordinacije;

    @NotNull
    @NotBlank
    private String adresa;

    @ManyToOne
    @JoinColumn(name = "specijalnost_id")
    private Specijalnost specijalnost;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    public ApiDoctorResponse(Long lijecnik_id, String radno_vrijeme, String naziv_ordinacije,
                             String adresa, Specijalnost specijalnost, Korisnik korisnik) {
        this.lijecnik_id = lijecnik_id;
        this.radno_vrijeme = radno_vrijeme;
        this.naziv_ordinacije = naziv_ordinacije;
        this.adresa = adresa;
        this.specijalnost = specijalnost;
        this.korisnik = korisnik;
    }

    public Long getLijecnik_id() {
        return lijecnik_id;
    }

    public void setLijecnik_id(Long lijecnik_id) {
        this.lijecnik_id = lijecnik_id;
    }

    public String getRadno_vrijeme() {
        return radno_vrijeme;
    }

    public void setRadno_vrijeme(String radno_vrijeme) {
        this.radno_vrijeme = radno_vrijeme;
    }

    public String getNaziv_ordinacije() {
        return naziv_ordinacije;
    }

    public void setNaziv_ordinacije(String naziv_ordinacije) {
        this.naziv_ordinacije = naziv_ordinacije;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Specijalnost getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(Specijalnost specijalnost) {
        this.specijalnost = specijalnost;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
