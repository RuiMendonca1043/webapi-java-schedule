package com.barbearia.real.backend.service;

import com.barbearia.real.backend.model.student.StudentRequest;
import com.barbearia.real.backend.model.student.StudentResponse;

import java.util.List;

public interface IStudentService {

    StudentResponse create(StudentRequest req);
    List<StudentResponse> getAll();
}
