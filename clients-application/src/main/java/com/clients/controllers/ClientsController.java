package com.clients.controllers;

import java.net.URI;
import java.util.List;

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

import com.clients.models.ClientDTO;
import com.clients.services.ClientsService;

@RestController
@RequestMapping("/v1/clients")
public class ClientsController {

	@Autowired
	ClientsService clientsService;

	@GetMapping("/{clientId}")
	public ResponseEntity<ClientDTO> findById(@PathVariable("clientId") Long clientId) {
		ClientDTO clientDTO = clientsService.findById(clientId);
		return new ResponseEntity<ClientDTO>(clientDTO, HttpStatus.OK);
	}

	@GetMapping("/fullname/{name}")
	public ResponseEntity<List<ClientDTO>> findByFullName(@PathVariable("name") String fullName) {
		List<ClientDTO> clients = clientsService.findByFullName(fullName);
		return new ResponseEntity<List<ClientDTO>>(clients, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
		clientsService.save(clientDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("").toUri();
		return ResponseEntity.created(location).build();
	}
}
