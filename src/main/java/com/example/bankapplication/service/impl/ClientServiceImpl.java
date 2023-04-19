package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.mapper.ClientMapper;
import com.example.bankapplication.repository.ClientRepository;
import com.example.bankapplication.service.ClientService;
import com.example.bankapplication.service.exception.ClientNotFoundException;
import com.example.bankapplication.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public List<ClientDto> getAllClients() {
        log.info("Get all clients");
        return clientMapper.clientsToClientsDto
                (clientRepository.findAllClients());
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
}
