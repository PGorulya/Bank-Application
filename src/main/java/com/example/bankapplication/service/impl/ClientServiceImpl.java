package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.entity.enums.ClientStatus;
import com.example.bankapplication.mapper.ClientMapper;
import com.example.bankapplication.repository.ClientRepository;
import com.example.bankapplication.service.ClientService;
import com.example.bankapplication.service.exception.ClientExistException;
import com.example.bankapplication.service.exception.ClientNotFoundException;
import com.example.bankapplication.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;


    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> getAllClientsByStatus(ClientStatus status) {
        log.info("Get clients with status {}", status);
        return clientMapper.clientsToClientsDto
                (clientRepository.findAllByStatus(status).
                        orElseThrow(
                                () -> new ClientNotFoundException
                                    (ErrorMessage.CLIENT_NOT_FOUND_BY_STATUS)));
    }

    @Override
    public List<ClientDto> getAllClients() {
        log.info("Get all clients");
        return clientMapper.clientsToClientsDto
                (clientRepository.findAll());
    }



    @Override
    @Transactional(readOnly = true)
    public ClientDto getClientById(UUID id) {
        log.info("Get clients with id = {}", id);
        return clientMapper.toDto(clientRepository.findClientById(id).
                orElseThrow(
                        () -> new ClientNotFoundException
                                (ErrorMessage.CLIENT_NOT_FOUND_BY_ID)));

    }

    @Override
    @Transactional
    public ClientDto addNewClient(ClientDto clientDto) {
        log.info("Addition the new Client");
        Client client = clientMapper.toClient(clientDto);
        Client existClient = clientRepository.findByTaxCode(client.getTaxCode());
        if(existClient != null)
            throw new ClientExistException("The client with the same Tax Code already exists");

        client.setId(UUID.randomUUID());
        client.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        client.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        log.info("Add new client {}", client);

        clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Override
    @Transactional
    public void deleteClientById(UUID id) {
        log.info("Deleting client {}", id);
        clientRepository.deleteById(id);
    }
}
