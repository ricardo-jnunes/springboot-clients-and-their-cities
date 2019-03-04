package com.clientscities.services;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientscities.entities.ClientEntity;
import com.clientscities.models.ClientDTO;
import com.clientscities.repositories.ClientRepository;

@Service
public class ClientsService {

	@Autowired
	ClientRepository clientRepository;

	public ClientDTO findById(Long clientId) {
		ModelMapper modelMapper = new ModelMapper();
		Optional<ClientEntity> clientEntity = clientRepository.findById(clientId);
		ClientDTO clientDTO = modelMapper
				.map(clientEntity.orElseThrow(() -> new EntityNotFoundException("Client not found in database.")), ClientDTO.class);
		return clientDTO;
	}

	public List<ClientDTO> findByFullName(String fullName) {
		Type listType = new TypeToken<List<ClientDTO>>() {
		}.getType();
		List<ClientEntity> clientEntity = clientRepository.findByFullName(fullName);
		List<ClientDTO> clientsDTO = new ModelMapper().map(clientEntity, listType);
		return clientsDTO;
	}

}
