package com.mip.projectbuilder.service;

import com.mip.projectbuilder.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    Client saveClient(Client client);
    List<Client> findAll();
    Client findById(UUID id);
}
