package com.barbearia.real.backend.controller;

import com.barbearia.real.backend.model.service.ServiceRequest;
import com.barbearia.real.backend.model.service.ServiceResponse;
import com.barbearia.real.backend.service.IServiceService;
import com.barbearia.real.backend.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/services")
public class ServiceController {

    @Autowired
    private IServiceService service;

    @PostMapping
    public ResponseEntity<ServiceResponse> create(@RequestBody ServiceRequest req){
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping
    public ResponseEntity<List<ServiceResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getById(@PathVariable String id){
        if(service.getById(id)==null){
            return ResponseEntity.ofNullable(service.getById(id));
        }
        return ResponseEntity.ok(service.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable String id, @RequestBody ServiceRequest req){
        return ResponseEntity.ok(service.update(id,req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable String id){
        return ResponseEntity.ok(service.delete(id));
    }
}
