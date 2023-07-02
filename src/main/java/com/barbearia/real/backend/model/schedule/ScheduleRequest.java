package com.barbearia.real.backend.model.schedule;

import com.barbearia.real.backend.model.client.ClientRequest;
import com.barbearia.real.backend.persistence.entity.Client;
import com.barbearia.real.backend.persistence.entity.Employee;
import com.barbearia.real.backend.persistence.entity.Service;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleRequest {
    private LocalTime time;
    private String serviceId;
    private String employeeId;
    private ClientRequest clientReq;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public ClientRequest getClientReq() {
        return clientReq;
    }

    public void setClientReq(ClientRequest clientReq) {
        this.clientReq = clientReq;
    }
}
