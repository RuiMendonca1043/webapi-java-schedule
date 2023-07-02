package com.barbearia.real.backend.service.cliente;

import com.barbearia.real.backend.model.client.ClientRequest;
import com.barbearia.real.backend.model.client.ClientResponse;

public interface IClientService {
    ClientResponse getById(String id);
    ClientResponse create(ClientRequest req);
}
