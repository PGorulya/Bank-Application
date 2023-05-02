package com.example.bankapplication.service;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.enums.ClientStatus;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<ClientDto> getAllClientsByStatus(ClientStatus status);

    ClientDto getClientById(UUID id);

    List<ClientDto> getAllClients();

    ClientDto addNewClient(ClientDto clientDto);


    void deleteClientById(UUID id);

}
