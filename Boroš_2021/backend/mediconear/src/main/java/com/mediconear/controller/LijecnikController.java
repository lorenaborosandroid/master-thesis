package com.mediconear.controller;

import com.mediconear.domain.Lijecnik;
import com.mediconear.request.PrijavaRequest;
import com.mediconear.response.ApiDoctorResponse;
import com.mediconear.response.ApiDoctorsResponse;
import com.mediconear.response.MessageResponse;
import com.mediconear.service.LijecnikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/doctors")
class LijecnikController {

    @Autowired
    private LijecnikServiceImpl lijecnikService;

    @GetMapping("")
    public ApiDoctorsResponse findAll()
    {
        return  new ApiDoctorsResponse(lijecnikService.findAll());
    }

    @GetMapping("/specialization/{id}")
    public ApiDoctorsResponse getDoctorsForSpeciality(@PathVariable("id") Long id){
        return new ApiDoctorsResponse(lijecnikService.getDoctorsForSpeciality(id));
    }

    @GetMapping("{id}")
    public ApiDoctorResponse getDoctorById(@PathVariable("id") Long id){
        Lijecnik doctor = lijecnikService.getDoctorById(id);
        return new ApiDoctorResponse(
                doctor.getLijecnik_id(),
                doctor.getRadno_vrijeme(),
                doctor.getNaziv_ordinacije(),
                doctor.getAdresa(),
                doctor.getSpecijalnost(),
                doctor.getKorisnik()
        );
    }

    @PostMapping("")
    public MessageResponse updateDoctor(@Valid @RequestBody Lijecnik request) {
        lijecnikService.updateDoctor(request);
        return new MessageResponse("Doctor updated");
    }
}