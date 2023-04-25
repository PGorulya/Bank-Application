package com.example.bankapplication.service;

import com.example.bankapplication.dto.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ClientDto getClientById(UUID id);

    List<ClientDto> getAllClients();

    ClientDto addNewClient(ClientDto clientDto);
}
