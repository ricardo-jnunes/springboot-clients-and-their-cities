package com.cities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cities.models.CityDTO;
import com.cities.services.CitiesService;

@RestController
@RequestMapping("/v1/cities")
public class CitiesController {

	@Autowired
	CitiesService citiesService;

	@GetMapping("/{id}")
	public ResponseEntity<CityDTO> findById(@PathVariable("id") Long clientId) {
		CityDTO clientDTO = citiesService.findById(clientId);
		return new ResponseEntity<CityDTO>(clientDTO, HttpStatus.OK);
	}

}
