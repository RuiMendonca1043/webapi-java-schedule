package com.barbearia.real.backend.service.service;

import com.barbearia.real.backend.model.service.ServiceRequest;
import com.barbearia.real.backend.model.service.ServiceResponse;
import com.barbearia.real.backend.persistence.repository.ServiceRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    private ServiceRepository repo;
    @Override
    public ServiceResponse create(ServiceRequest req) {
        com.barbearia.real.backend.persistence.entity.Service s = createService(req);

        repo.save(s);

        return createResponse(s);
    }

    @Override
    public List<ServiceResponse> getAll() {
        List<ServiceResponse> res = new ArrayList<>();
        List<com.barbearia.real.backend.persistence.entity.Service> services = repo.findAll();
        if(!services.isEmpty()){
            services.forEach(service -> res.add(createResponse(service)));
        }
        return res;
    }

    @Override
    public ServiceResponse getById(String id) {
        com.barbearia.real.backend.persistence.entity.Service existingService = repo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found Service with this id: "+id));

        return createResponse(existingService);
    }

    @Override
    public ServiceResponse update(String id, ServiceRequest req) {
        com.barbearia.real.backend.persistence.entity.Service existingService = repo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found Service with this id: "+id));
        com.barbearia.real.backend.persistence.entity.Service s = updateService(existingService,req);
        repo.save(s);
        return createResponse(s);
    }

    @Override
    public ServiceResponse delete(String id) {
        com.barbearia.real.backend.persistence.entity.Service existingService = repo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not Found Service with this id: "+id));

        repo.delete(existingService);

        return createResponse(existingService);
    }


    private ServiceResponse createResponse(com.barbearia.real.backend.persistence.entity.Service s){
        ServiceResponse res = new ServiceResponse();
        res.setId(s.getId());
        res.setTitle(s.getTitle());
        res.setDescription(s.getDescription());
        res.setPrice(s.getPrice());
        res.setTime(s.getTime());
        res.setType(s.getType());
        return res;
    }
    private com.barbearia.real.backend.persistence.entity.Service createService(ServiceRequest req){
        com.barbearia.real.backend.persistence.entity.Service s = new com.barbearia.real.backend.persistence.entity.Service();
        s.setDescription(req.getDescription());
        s.setPrice(req.getPrice());
        s.setTitle(req.getTitle());
        s.setType(req.getType());
        s.setTime(req.getTime());
        return s;
    }
    private com.barbearia.real.backend.persistence.entity.Service updateService(
            com.barbearia.real.backend.persistence.entity.Service service, ServiceRequest req){
        service.setTitle(req.getTitle());
        service.setType(req.getType());
        service.setTime(req.getTime());
        service.setPrice(req.getPrice());
        service.setDescription(req.getDescription());
        return service;
    }
}
