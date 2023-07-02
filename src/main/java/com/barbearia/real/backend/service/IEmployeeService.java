package com.barbearia.real.backend.service;

import com.barbearia.real.backend.model.employee.EmployeeRequest;
import com.barbearia.real.backend.model.employee.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {
    List<EmployeeResponse> getAll();
    EmployeeResponse getById(String id);
    EmployeeResponse create(EmployeeRequest req);
}
