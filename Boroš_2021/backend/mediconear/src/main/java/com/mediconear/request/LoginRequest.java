package com.mediconear.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String lozinka;

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
