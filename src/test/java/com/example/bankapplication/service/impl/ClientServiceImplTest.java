package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.entity.enums.ClientStatus;
import com.example.bankapplication.mapper.ClientMapper;
import com.example.bankapplication.repository.ClientRepository;
import com.example.bankapplication.service.exception.ClientNotFoundException;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Client Service test class")
@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {
    @InjectMocks
    ClientServiceImpl service;
    @Mock
    ClientMapper clientMapper;
    @Mock
    ClientRepository clientRepository;

    private final ClientStatus status = ClientStatus.ACTIVE;
    Client client = EntityCreator.getClientEntity();
    ClientDto clientDto = DtoCreator.getClientDto();

    @Test
    @DisplayName("Positive test. Get all clients by status")
    void getAllClientsByStatusTest() {
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientDtoList.add(clientDto);

        Mockito.when(clientRepository.findAllByStatus(status)).thenReturn(Optional.of(clientList));
        Mockito.when(clientMapper.clientsToClientsDto(clientList)).thenReturn(clientDtoList);

        service.getAllClientsByStatus(status);

        Mockito.verify(clientRepository).findAllByStatus(status);
        Mockito.verify(clientMapper).clientsToClientsDto(clientList);
    }

    @Test
    @DisplayName("Positive test. Get all clients")
    void getAllClientsTest() {
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientDtoList.add(clientDto);

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);
        Mockito.when(clientMapper.clientsToClientsDto(clientList)).thenReturn(clientDtoList);

        service.getAllClients();

        Mockito.verify(clientRepository).findAll();
        Mockito.verify(clientMapper).clientsToClientsDto(clientList);
    }

    @Test
    @DisplayName("Positive Test. Get client by id")
    void getClientByIdTest() {
        Client client = EntityCreator.getClientEntity();
        ClientDto clientDto = DtoCreator.getClientDto();

        Mockito.when(clientRepository.findClientById(client.getId())).thenReturn(Optional.of(client));
        Mockito.when(clientMapper.toDto(client)).thenReturn(clientDto);

        service.getClientById(client.getId());

        Mockito.verify(clientRepository).findClientById(client.getId());
        Mockito.verify(clientMapper).toDto(client);
    }

    @Test
    @DisplayName("Negative test. There is no element. Get client by Id.")
    void getNotExistClientByIdTest() {
        UUID id = EntityCreator.UUID_EXAMPLE;
        assertThrows(ClientNotFoundException.class, () -> service.getClientById(id));
    }

}