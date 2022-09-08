package com.mediconear.request;

import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Pacijent;
import com.mediconear.domain.Specijalnost;

public class PrijavaRequest {

    private Pacijent pacijent_id;
    private Lijecnik lijecnik_id;
    private Specijalnost specijalizacija_id;

    public PrijavaRequest(Pacijent pacijent_id, Lijecnik lijecnik_id, Specijalnost specijalizacija_id) {
        this.pacijent_id = pacijent_id;
        this.lijecnik_id = lijecnik_id;
        this.specijalizacija_id = specijalizacija_id;
    }

    public Pacijent getPacijent_id() {
        return pacijent_id;
    }

    public void setPacijent_id(Pacijent pacijent_id) {
        this.pacijent_id = pacijent_id;
    }

    public Lijecnik getLijecnik_id() {
        return lijecnik_id;
    }

    public void setLijecnik_id(Lijecnik lijecnik_id) {
        this.lijecnik_id = lijecnik_id;
    }

    public Specijalnost getSpecijalizacija_id() {
        return specijalizacija_id;
    }

    public void setSpecijalizacija_id(Specijalnost specijalizacija_id) {
        this.specijalizacija_id = specijalizacija_id;
    }
}
