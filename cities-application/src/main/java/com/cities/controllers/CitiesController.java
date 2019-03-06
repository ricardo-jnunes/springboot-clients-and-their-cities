package com.cities.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping("/")
	public ResponseEntity<CityDTO> saveClient(@RequestBody CityDTO cityDTO) {
		citiesService.save(cityDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("").toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/queue")
	public ResponseEntity<String> sendToRabbitMQ(@RequestBody String value) {
		citiesService.sendToRabbitMQ(value);
		return new ResponseEntity<String>(value, HttpStatus.OK);
	}

}
