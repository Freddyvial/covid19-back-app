package com.poli.covid19.controllers;

import com.poli.covid19.domain.Medical;
import com.poli.covid19.services.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class MedicalController {

	@Autowired
	private MedicalService medicalService;

	@GetMapping("/medical")
	public List<Medical> getMedical() {
		return medicalService.getMedical();
	}
	@GetMapping("/checkMedical")
	public Medical checkMedical(String userName) {
		return medicalService.checkMedical(userName);
	}
	@PostMapping(path ="/medical", consumes="application/json", produces = "application/json")
	public	Medical createMedical(@RequestBody Medical medical) throws Exception {

		return medicalService.createMedical(medical);
	}

}