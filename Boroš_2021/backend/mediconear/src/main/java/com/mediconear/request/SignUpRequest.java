package com.mediconear.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    //podaci za prijavu
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String lozinka;

    private String ime;

    private String prezime;

    private String kontaktni_broj;

    private String oib;

    private String datum_rodjenja;

    private String mbo;

    private String naziv_ordinacije;

    private String radno_vrijeme;

    private String adresa;

    private boolean isUserDoctor;

    public String getEmail() {
        return email;
    }

    public String getMbo() {
        return mbo;
    }

    public void setMbo(String mbo) {
        this.mbo = mbo;
    }

    public String getNaziv_ordinacije() {
        return naziv_ordinacije;
    }

    public void setNaziv_ordinacije(String naziv_ordinacije) {
        this.naziv_ordinacije = naziv_ordinacije;
    }

    public String getRadno_vrijeme() {
        return radno_vrijeme;
    }

    public void setRadno_vrijeme(String radno_vrijeme) {
        this.radno_vrijeme = radno_vrijeme;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontaktni_broj() {
        return kontaktni_broj;
    }

    public void setKontaktni_broj(String kontaktni_broj) {
        this.kontaktni_broj = kontaktni_broj;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(String datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public boolean getIsUserDoctor() {
        return isUserDoctor;
    }

    public void setIsUserDoctor(boolean userDoctor) {
        isUserDoctor = userDoctor;
    }
}
