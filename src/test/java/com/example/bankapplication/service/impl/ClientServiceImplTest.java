package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.mapper.ClientMapper;
import com.example.bankapplication.repository.ClientRepository;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@DisplayName("Client Service test class")
@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {
    @InjectMocks
    ClientServiceImpl service;
    @Mock
    ClientMapper clientMapper;
    @Mock
    ClientRepository clientRepository;

    @Test
    void getAllClientsByStatusTest() {
    }

    @Test
    void getAllClientsTest() {
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
    void addNewClientTest() {
    }

    @Test
    void deleteClientByIdTest() {
    }
}