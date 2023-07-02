package com.barbearia.real.backend.controller;

import com.barbearia.real.backend.model.employee.EmployeeResponse;
import com.barbearia.real.backend.persistence.entity.Employee;
import com.barbearia.real.backend.service.IEmployeeService;
import com.barbearia.real.backend.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}