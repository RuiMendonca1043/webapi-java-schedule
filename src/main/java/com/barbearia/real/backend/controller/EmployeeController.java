package com.barbearia.real.backend.controller;

import com.barbearia.real.backend.model.employee.EmployeeRequest;
import com.barbearia.real.backend.model.employee.EmployeeResponse;
import com.barbearia.real.backend.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

@GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody EmployeeRequest req){
        return ResponseEntity.ok(service.create(req));
    }
}
