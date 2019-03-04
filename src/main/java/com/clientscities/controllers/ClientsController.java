package com.clientscities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientscities.models.ClientDTO;
import com.clientscities.services.ClientsService;

@RestController
@RequestMapping("/v1/clients")
public class ClientsController {

	@Autowired
	ClientsService clientsService;

	@GetMapping("/fullname/{name}")
	public ResponseEntity<List<ClientDTO>> findByFullName(@PathVariable("name") String fullName) {
		List<ClientDTO> clients = clientsService.findByFullName(fullName);
		return new ResponseEntity<List<ClientDTO>>(clients, HttpStatus.OK);
	}
}
