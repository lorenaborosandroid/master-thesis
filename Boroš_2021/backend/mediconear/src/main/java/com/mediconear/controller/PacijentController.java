package com.mediconear.controller;

import com.mediconear.domain.Pacijent;
import com.mediconear.response.ApiPatientResponse;
import com.mediconear.service.PacijentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/patients")
public class PacijentController {

    @Autowired
    private PacijentServiceImpl pacijentService;


    @GetMapping("")
    public List<Pacijent> findAll()
    {
        return (pacijentService.findAll());
    }

    @GetMapping("{id}")
    public ApiPatientResponse getPatientById(@PathVariable("id") Long id){
        Pacijent patient = pacijentService.getPatientById(id);
        return new ApiPatientResponse(
                patient.getPacijent_id(),
                patient.getKorisnik(),
                patient.getMbo()
        );
    }
}
