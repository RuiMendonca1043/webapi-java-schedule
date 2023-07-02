package com.barbearia.real.backend.persistence.repository;

import com.barbearia.real.backend.persistence.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
