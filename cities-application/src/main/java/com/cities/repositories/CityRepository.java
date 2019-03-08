package com.cities.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cities.entities.CityEntity;

public interface CityRepository extends MongoRepository<CityEntity, Long> {

}
