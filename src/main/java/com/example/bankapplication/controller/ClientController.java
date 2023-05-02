package com.example.bankapplication.controller;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.enums.ClientStatus;
import com.example.bankapplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAllClientsByStatus(@PathVariable ClientStatus status) {
        return clientService.getAllClientsByStatus(status);
    }

    @GetMapping("/clients/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientById(@PathVariable UUID id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping(path = "/clients/newClient", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto addNewClient(@RequestBody ClientDto clientDto) {
        return clientService.addNewClient(clientDto);
    }

    @DeleteMapping("/clients/deleteClient/{id}")
    public void deleteClientById(@PathVariable UUID id) {
        clientService.deleteClientById(id);
    }
}
