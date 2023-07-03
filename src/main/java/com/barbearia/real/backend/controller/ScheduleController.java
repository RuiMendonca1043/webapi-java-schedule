package com.barbearia.real.backend.controller;

import com.barbearia.real.backend.model.schedule.ScheduleRequest;
import com.barbearia.real.backend.model.schedule.ScheduleResponse;
import com.barbearia.real.backend.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("v1/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<ScheduleResponse> create(@RequestBody ScheduleRequest req){
        return ResponseEntity.ok(service.create(req));
    }
}
