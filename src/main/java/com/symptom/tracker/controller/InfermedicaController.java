package com.symptom.tracker.controller;

import com.symptom.tracker.service.CovidSymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfermedicaController {

    @Autowired
    CovidSymptomsService covidSymptomsService;

    @GetMapping(value = "/covid19/symptoms", produces = MediaType.APPLICATION_JSON_VALUE)
    public List getCovid19Symptoms() {
        return covidSymptomsService.getCovid19Symptoms();
    }
}
