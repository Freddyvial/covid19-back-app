package com.poli.covid19.controllers;

import com.poli.covid19.domain.Patient;
import com.poli.covid19.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientsService.getPatients();
    }

    @PostMapping(path = "/patients", consumes = "application/json", produces = "application/json")
    public Patient createPatients(@RequestBody Patient patient) throws Exception {
            return patientsService.createPatient(patient);
    }

}