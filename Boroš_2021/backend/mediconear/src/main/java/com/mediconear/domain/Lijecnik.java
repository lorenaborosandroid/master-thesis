package com.mediconear.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lijecnik {

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
