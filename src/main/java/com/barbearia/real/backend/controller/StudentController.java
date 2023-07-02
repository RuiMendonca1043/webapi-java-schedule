package com.barbearia.real.backend.controller;

import com.barbearia.real.backend.model.student.StudentRequest;
import com.barbearia.real.backend.model.student.StudentResponse;
import com.barbearia.real.backend.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_v0/student")
public class StudentController {

    @Autowired
    private IStudentService service;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request){
        return ResponseEntity.ok(service.create(request));
    }
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
