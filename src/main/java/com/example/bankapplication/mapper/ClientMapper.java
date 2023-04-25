package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface ClientMapper {
    @Mapping(source = "client.manager.id", target = "managerId")
    ClientDto toDto(Client client);

    List<ClientDto> clientsToClientsDto(List<Client> clients);

    Client toClient(ClientDto clientDto);
}
