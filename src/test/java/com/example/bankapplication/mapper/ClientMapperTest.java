package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.mapper.impl.ClientMapperImplTest;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Client Mapper test class")
class ClientMapperTest {

    private final ClientMapper clientMapper = new ClientMapperImplTest();

    @Test
    void toDtoTest() {
        Client client = EntityCreator.getClientEntity();
        ClientDto clientDto = DtoCreator.getClientDto();

        Assertions.assertEquals(clientDto, clientMapper.toDto(client));
    }

    @Test
    @DisplayName("Positive test. Clients list mapper to list ClientDto")
    void clientsToClientsDtoTest() {
        Client client = EntityCreator.getClientEntity();
        List<Client> clientList = new ArrayList();
        clientList.add(client);
        List<ClientDto> ClientDtoList = new ArrayList<>();
        ClientDtoList.add(DtoCreator.getClientDto());

        Assertions.assertEquals(ClientDtoList, clientMapper.clientsToClientsDto(clientList));
    }

    @Test
    void toClientTest() {
        Client client = EntityCreator.getClientEntity();
        ClientDto clientDto = DtoCreator.getClientDto();

        Assertions.assertEquals(client, clientMapper.toClient(clientDto));
    }
}