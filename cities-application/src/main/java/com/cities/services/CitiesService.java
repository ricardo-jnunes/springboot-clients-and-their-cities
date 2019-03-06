package com.cities.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cities.entities.CityEntity;
import com.cities.models.CityDTO;
import com.cities.repositories.CityRepository;

@Service
public class CitiesService {

	@Autowired
	CityRepository cityRepository;

	public CityDTO findById(Long clientId) {
		ModelMapper modelMapper = new ModelMapper();
		Optional<CityEntity> clientEntity = cityRepository.findById(clientId);
		CityDTO clientDTO = modelMapper.map(
				clientEntity.orElseThrow(() -> new EntityNotFoundException("City not found in database.")),
				CityDTO.class);
		return clientDTO;
	}

	public void save(CityDTO cityDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CityEntity clientEntity = modelMapper.map(cityDTO, CityEntity.class);
		cityRepository.save(clientEntity);
	}

}
