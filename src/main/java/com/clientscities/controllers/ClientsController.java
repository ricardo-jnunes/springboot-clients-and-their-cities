package com.clientscities.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientscities.dto.Client;

@RestController
public class ClientsController {

	@GetMapping("/greeting")
	public ResponseEntity<Client> greeting() {
        return new ResponseEntity<Client>(HttpStatus.OK);
	}
}
