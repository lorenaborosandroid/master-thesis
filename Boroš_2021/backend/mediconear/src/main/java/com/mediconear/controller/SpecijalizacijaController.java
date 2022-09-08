package com.mediconear.controller;

import com.mediconear.response.ApiSpecializationTypes;
import com.mediconear.service.SpecijalizacijaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/specijalizacija")
public class SpecijalizacijaController {

    @Autowired
    private SpecijalizacijaServiceImpl service;

    @GetMapping("")
    public ApiSpecializationTypes findAll()
    {
        return new ApiSpecializationTypes(service.findAll());
    }
}
