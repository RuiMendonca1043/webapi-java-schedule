package com.barbearia.real.backend.service.cliente;

import com.barbearia.real.backend.model.client.ClientRequest;
import com.barbearia.real.backend.model.client.ClientResponse;
import com.barbearia.real.backend.persistence.entity.Client;
import com.barbearia.real.backend.persistence.repository.ClientRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{
    @Autowired
    private ClientRepository repo;
    @Override
    public ClientResponse getById(String id) {
        Client c = repo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Not Found Client with this id: \"+id"));
        return createRes(c);
    }

    @Override
    public ClientResponse create(ClientRequest req) {
        Client c = createClient(req);
        repo.save(c);
        return createRes(c);
    }

    private ClientResponse createRes(Client c){
        ClientResponse res = new ClientResponse();
        res.setId(c.getId());
        res.setName(c.getName());
        res.setEmail(c.getEmail());
        res.setPhoneNumber(c.getPhoneNumber());
        return res;
    }
    private Client createClient(ClientRequest req){
        Client c = new Client();
        c.setName(req.getName());
        c.setEmail(req.getEmail());
        c.setPhoneNumber(req.getPhoneNumber());
        return c;
    }
}
