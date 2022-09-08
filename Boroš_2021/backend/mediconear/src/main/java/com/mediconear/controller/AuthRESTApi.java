package com.mediconear.controller;

import com.mediconear.domain.Korisnik;
import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Pacijent;
import com.mediconear.repository.KorisnikRepository;
import com.mediconear.repository.LijecnikRepository;
import com.mediconear.repository.PacijentRepository;
import com.mediconear.request.LoginRequest;
import com.mediconear.request.SignUpRequest;
import com.mediconear.response.LoginResponse;
import com.mediconear.response.MessageResponse;
import com.mediconear.security.jwt.JwtProvider;
import com.mediconear.service.KorisnikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * Registracija i prijava u sustav.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRESTApi
{
    @Autowired
    KorisnikServiceImpl korisnikService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    LijecnikRepository lijecnikRepository;

    @Autowired
    PacijentRepository pacijentRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
    {
        Authentication authentication = null;
        authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getLozinka()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Korisnik korisnik = korisnikService.findByEmail(userDetails.getUsername()).
                orElseThrow(() -> new RuntimeException("Korisnik ne postoji u bazi."));

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setKorisnik(korisnik);
        loginResponse.setToken(jwt);
        return loginResponse;
    }

    @PostMapping("/signup")
    public MessageResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest)
    {
        if (korisnikRepository.existsByEmail(signUpRequest.getEmail()))
            throw new RuntimeException("Email već postoji u bazi!");

        Korisnik korisnik = new Korisnik();
        korisnik.setEmail(signUpRequest.getEmail());
        korisnik.setLozinka(encoder.encode(signUpRequest.getLozinka()));
        korisnik.setIme(signUpRequest.getIme());
        korisnik.setPrezime(signUpRequest.getPrezime());
        korisnik.setKontakt_broj(signUpRequest.getKontaktni_broj());
        korisnik.setOib(signUpRequest.getOib());
        korisnik.setDatum_rodjenja(signUpRequest.getDatum_rodjenja());
        korisnikRepository.save(korisnik);

        if(signUpRequest.getIsUserDoctor()) {
            Lijecnik lijecnik = new Lijecnik();
            lijecnik.setKorisnik(korisnik);
            lijecnik.setAdresa(signUpRequest.getAdresa());
            lijecnik.setRadno_vrijeme(signUpRequest.getRadno_vrijeme());
            lijecnik.setNaziv_ordinacije(signUpRequest.getNaziv_ordinacije());
            lijecnikRepository.save(lijecnik);
        } else {
            Pacijent pacijent = new Pacijent();
            pacijent.setKorisnik(korisnik);
            pacijent.setMbo(signUpRequest.getMbo());
            pacijentRepository.save(pacijent);
        }

        return new MessageResponse("New user added successfully");
    }
}
