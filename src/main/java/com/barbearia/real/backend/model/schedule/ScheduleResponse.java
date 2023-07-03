package com.barbearia.real.backend.model.schedule;

import com.barbearia.real.backend.model.client.ClientRequest;
import com.barbearia.real.backend.model.client.ClientResponse;
import com.barbearia.real.backend.model.employee.EmployeeResponse;
import com.barbearia.real.backend.model.service.ServiceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScheduleResponse {
    private String id;
    private LocalDateTime dateTime;
    private ServiceResponse service;
    private EmployeeResponse employee;
    private ClientResponse client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime time) {
        this.dateTime = time;
    }

    public ServiceResponse getService() {
        return service;
    }

    public void setService(ServiceResponse service) {
        this.service = service;
    }

    public EmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponse employee) {
        this.employee = employee;
    }

    public ClientResponse getClient() {
        return client;
    }

    public void setClient(ClientResponse client) {
        this.client = client;
    }
}
