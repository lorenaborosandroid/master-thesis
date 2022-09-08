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
public class Pacijent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacijent_id;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @NotNull
    @NotBlank
    private String mbo;


    public Long getPacijent_id() {
        return pacijent_id;
    }

    public void setPacijent_id(Long pacijent_id) {
        this.pacijent_id = pacijent_id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getMbo() {
        return mbo;
    }

    public void setMbo(String mbo) {
        this.mbo = mbo;
    }
}
