package com.mediconear.response;

import com.mediconear.domain.Specijalnost;

import java.util.List;

public class ApiSpecializationTypes {

    public ApiSpecializationTypes(List<Specijalnost> types) {
        this.types = types;
    }

    private List<Specijalnost> types;

    public List<Specijalnost> getTypes() {
        return types;
    }

    public void setTypes(List<Specijalnost> types) {
        this.types = types;
    }
}
