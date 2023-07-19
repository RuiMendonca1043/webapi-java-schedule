package com.barbearia.real.backend.service.schedule;

import com.barbearia.real.backend.model.schedule.ScheduleRequest;
import com.barbearia.real.backend.model.schedule.ScheduleResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IScheduleService {
    ScheduleResponse getById(String id);
    List<ScheduleResponse> getAll();
    ScheduleResponse create(ScheduleRequest req);
    ScheduleResponse delete(String id);

    List<ScheduleResponse> getByDay(LocalDate day);
}
