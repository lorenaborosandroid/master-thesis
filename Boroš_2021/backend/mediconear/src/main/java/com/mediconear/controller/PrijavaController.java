package com.mediconear.controller;

import com.mediconear.domain.Prijava;
import com.mediconear.request.PrijavaRequest;
import com.mediconear.response.ApiPatientDoctorSignUpsResponse;
import com.mediconear.response.MessageResponse;
import com.mediconear.service.PrijavaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/prijava")
public class PrijavaController {

    @Autowired
    private PrijavaServiceImpl prijavaService;

    @PostMapping("")
    public MessageResponse createPrijava(@Valid @RequestBody PrijavaRequest form)
    {
        Prijava saved = new Prijava();

        saved.setLijecnik(form.getLijecnik_id());
        saved.setPacijent(form.getPacijent_id());
        saved.setSpecijalnost(form.getSpecijalizacija_id());
        prijavaService.createPrijava(saved);
        return new MessageResponse("Prijava uspješno kreirana.");
    }

    @GetMapping("")
    public ApiPatientDoctorSignUpsResponse findAll()
    {
        return new ApiPatientDoctorSignUpsResponse(prijavaService.findAll());
    }
}
