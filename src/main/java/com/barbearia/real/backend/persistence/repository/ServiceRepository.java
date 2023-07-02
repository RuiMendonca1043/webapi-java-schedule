package com.barbearia.real.backend.persistence.repository;

import com.barbearia.real.backend.persistence.entity.Service;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {
}
