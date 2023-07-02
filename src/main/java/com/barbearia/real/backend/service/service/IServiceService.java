package com.barbearia.real.backend.service.service;

import com.barbearia.real.backend.model.service.ServiceRequest;
import com.barbearia.real.backend.model.service.ServiceResponse;

import java.util.List;

public interface IServiceService {
    ServiceResponse create(ServiceRequest req);
    List<ServiceResponse> getAll();
    ServiceResponse getById(String id);
    ServiceResponse update(String id, ServiceRequest req);
    ServiceResponse delete(String id);
}
