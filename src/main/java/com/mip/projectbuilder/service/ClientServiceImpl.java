package com.mip.projectbuilder.service;

import com.mip.projectbuilder.entity.Client;
import com.mip.projectbuilder.exception.ClientNotFoundException;
import com.mip.projectbuilder.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client saveClient(Client client) {
        Client savedClient = repository.save(client);
        logger.info("Client[{}] was successfully created", savedClient);
        return savedClient;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
}
