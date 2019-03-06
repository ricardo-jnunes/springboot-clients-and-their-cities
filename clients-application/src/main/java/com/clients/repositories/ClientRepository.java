package com.clients.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clients.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

	List<ClientEntity> findByFullName(String fullName);

}
