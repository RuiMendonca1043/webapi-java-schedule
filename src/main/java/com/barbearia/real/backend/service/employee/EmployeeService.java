package com.barbearia.real.backend.service.employee;

import com.barbearia.real.backend.model.employee.EmployeeRequest;
import com.barbearia.real.backend.model.employee.EmployeeResponse;
import com.barbearia.real.backend.persistence.entity.Employee;
import com.barbearia.real.backend.persistence.repository.EmployeeRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<EmployeeResponse> getAll() {
        List<EmployeeResponse> res = new ArrayList<>();
        List<Employee> employees = repo.findAll();
        if(!employees.isEmpty()){
            employees.forEach(employee -> res.add(createResponse(employee)));
        }
        return res;
    }

    @Override
    public EmployeeResponse getById(String id) {
        Employee existingEmployee = repo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found Employee with this id: "+id));
        return createResponse(existingEmployee);
    }

    @Override
    public EmployeeResponse create(EmployeeRequest req) {
        Employee e = createEmployee(req);
        repo.save(e);
        return createResponse(e);
    }

    private EmployeeResponse createResponse(Employee e){
        EmployeeResponse res = new EmployeeResponse();
        res.setId(e.getId());
        res.setName(e.getName());
        return res;
    }
    private Employee createEmployee(EmployeeRequest req){
        Employee e = new Employee();
        e.setName(req.getName());
        return e;
    }
}
