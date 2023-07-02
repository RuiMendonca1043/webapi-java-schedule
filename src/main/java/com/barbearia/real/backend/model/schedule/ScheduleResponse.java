package com.barbearia.real.backend.model.schedule;

import com.barbearia.real.backend.model.client.ClientRequest;
import com.barbearia.real.backend.model.client.ClientResponse;
import com.barbearia.real.backend.model.employee.EmployeeResponse;
import com.barbearia.real.backend.model.service.ServiceResponse;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleResponse {
    private LocalDate date;
    private LocalTime time;
    private ServiceResponse service;
    private EmployeeResponse employee;
    private ClientResponse client;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
