package com.mediconear.response;

import com.mediconear.domain.Korisnik;

public class LoginResponse {

    private Korisnik korisnik;
    private String token;

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
