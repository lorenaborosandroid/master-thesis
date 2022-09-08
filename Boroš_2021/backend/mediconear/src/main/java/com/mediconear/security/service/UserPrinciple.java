package com.mediconear.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mediconear.domain.Korisnik;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    @JsonIgnore
    private String lozinka;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id,
                         String email, String lozinka,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.lozinka = lozinka;
        this.authorities = authorities;
    }

    public static UserPrinciple build(Korisnik korisnik) {
       /* List<GrantedAuthority> authorities = osoba.getRoles().stream().map
                (role ->new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());*/
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ULOGA"));


        return new UserPrinciple(
                korisnik.getKorisnik_id(),
                korisnik.getEmail(),
                korisnik.getLozinka(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return lozinka;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
