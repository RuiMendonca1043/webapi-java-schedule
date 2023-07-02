package com.barbearia.real.backend.persistence.repository;

import com.barbearia.real.backend.persistence.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
}
