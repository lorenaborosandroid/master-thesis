package com.mediconear.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prijava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prijava_id;

    @ManyToOne
    @JoinColumn(name = "lijecnik_id")
    private Lijecnik lijecnik;

    @ManyToOne
    @JoinColumn(name = "pacijent_id")
    private Pacijent pacijent;

    @ManyToOne
    @JoinColumn(name = "specijalnost_id")
    private Specijalnost specijalnost;

    public Long getPrijava_id() {
        return prijava_id;
    }

    public void setPrijava_id(Long prijava_id) {
        this.prijava_id = prijava_id;
    }

    public Lijecnik getLijecnik() {
        return lijecnik;
    }

    public void setLijecnik(Lijecnik lijecnik) {
        this.lijecnik = lijecnik;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Specijalnost getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(Specijalnost specijalnost) {
        this.specijalnost = specijalnost;
    }
}
