package com.mediconear.security.service;

import com.mediconear.domain.Korisnik;
import com.mediconear.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    KorisnikRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Korisnik korisnik = repository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> email : " + email));

        return UserPrinciple.build(korisnik);
    }
}
