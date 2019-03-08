package com.cities.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cities.entities.CityEntity;
import com.cities.models.CityDTO;
import com.cities.repositories.CityRepository;
import com.mongodb.MongoException;

@Service
public class CitiesService {

	@Autowired
	private RabbitMQMessageSender rmqMessageSender;

	@Autowired
	CityRepository cityRepository;

	public CityDTO findById(Long clientId) {
		ModelMapper modelMapper = new ModelMapper();
		Optional<CityEntity> cityEntity = cityRepository.findById(clientId);
		CityDTO cityDTO = modelMapper
				.map(cityEntity.orElseThrow(() -> new MongoException("Client not found in database.")), CityDTO.class);
		return cityDTO;
	}

	public void save(CityDTO cityDTO) {
		ModelMapper modelMapper = new ModelMapper();
		CityEntity clientEntity = modelMapper.map(cityDTO, CityEntity.class);
		cityRepository.save(clientEntity);
	}

	public void sendToRabbitMQ(String value) {
		rmqMessageSender.send(value);
	}

}
