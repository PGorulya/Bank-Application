package com.example.bankapplication.service;

import com.example.bankapplication.dto.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<ClientDto> getAllClients();

    ClientDto getClientById(UUID id);

}
