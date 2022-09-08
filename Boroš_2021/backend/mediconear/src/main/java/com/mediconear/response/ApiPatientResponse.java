package com.mediconear.response;

import com.mediconear.domain.Korisnik;

public class ApiPatientResponse {

    private Long pacijent_id;
    private Korisnik korisnik;
    private String mbo;

    public ApiPatientResponse(Long pacijent_id, Korisnik korisnik, String mbo) {
        this.pacijent_id = pacijent_id;
        this.korisnik = korisnik;
        this.mbo = mbo;
    }

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
