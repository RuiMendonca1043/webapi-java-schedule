package com.barbearia.real.backend.persistence.repository;

import com.barbearia.real.backend.persistence.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String> {
}
