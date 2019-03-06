package com.cities.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cities.entities.CityEntity;

public interface CityRepository extends CrudRepository<CityEntity, Long> {

}
