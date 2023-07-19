package com.barbearia.real.backend.persistence.repository;

import com.barbearia.real.backend.persistence.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String> {
    List<Schedule> findByDateTimeBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
