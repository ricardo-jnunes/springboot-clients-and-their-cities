package com.clientscities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clientscities.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

	List<ClientEntity> findByFullName(String fullName);

}
