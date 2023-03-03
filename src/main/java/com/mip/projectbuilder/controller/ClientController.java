package com.mip.projectbuilder.controller;

import com.mip.projectbuilder.entity.Client;
import com.mip.projectbuilder.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping(consumes = {"application/json"}, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return service.saveClient(client);
    }

    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable(name = "id") UUID id) {
        return service.findById(id);
    }
}
