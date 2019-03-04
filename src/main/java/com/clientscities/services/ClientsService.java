package com.clientscities.services;

import java.lang.reflect.Type;
import java.util.List;

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

	public List<ClientDTO> findByFullName(String fullName) {
		Type listType = new TypeToken<List<ClientDTO>>() {}.getType();

		List<ClientEntity> clientEntity = clientRepository.findByFullName(fullName);

		List<ClientDTO> clientDTO = new ModelMapper().map(clientEntity, listType);

//		ClientDTO clientDTO = modelMapper.map(clientEntity, ClientDTO.class);
		return clientDTO;
	}

}
