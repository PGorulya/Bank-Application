package com.example.bankapplication.mapper.impl;

import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ClientStatus;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.example.bankapplication.mapper.ClientMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImplTest implements ClientMapper {
    public void ClientMapperImpl() {
    }

    public ClientDto toDto(Client client) {
        if (client == null) {
            return null;
        } else {
            String managerId = null;
            String id = null;
            String status = null;
            String taxCode = null;
            String firstName = null;
            String lastName = null;
            String email = null;
            String address = null;
            String phone = null;
            Timestamp createdAt = null;
            Timestamp updatedAt = null;
            UUID id1 = this.clientManagerId(client);
            if (id1 != null) {
                managerId = id1.toString();
            }

            if (client.getId() != null) {
                id = client.getId().toString();
            }

            if (client.getStatus() != null) {
                status = client.getStatus().name();
            }

            taxCode = client.getTaxCode();
            firstName = client.getFirstName();
            lastName = client.getLastName();
            email = client.getEmail();
            address = client.getAddress();
            phone = client.getPhone();
            createdAt = client.getCreatedAt();
            updatedAt = client.getUpdatedAt();
            ClientDto clientDto = new ClientDto(id, status, taxCode, firstName, lastName, managerId, email, address, phone, createdAt, updatedAt);
            return clientDto;
        }
    }

    public List<ClientDto> clientsToClientsDto(List<Client> clients) {
        if (clients == null) {
            return null;
        } else {
            List<ClientDto> list = new ArrayList(clients.size());
            Iterator var3 = clients.iterator();

            while(var3.hasNext()) {
                Client client = (Client)var3.next();
                list.add(this.toDto(client));
            }

            return list;
        }
    }

    public Client toClient(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        } else {
            Client client = new Client();
            if (clientDto.getId() != null) {
                client.setId(UUID.fromString(clientDto.getId()));
            }

            if (clientDto.getStatus() != null) {
                client.setStatus((ClientStatus)Enum.valueOf(ClientStatus.class, clientDto.getStatus()));
            }

            client.setTaxCode(clientDto.getTaxCode());
            client.setFirstName(clientDto.getFirstName());
            client.setLastName(clientDto.getLastName());
            client.setEmail(clientDto.getEmail());
            client.setAddress(clientDto.getAddress());
            client.setPhone(clientDto.getPhone());
            client.setCreatedAt(clientDto.getCreatedAt());
            client.setUpdatedAt(clientDto.getUpdatedAt());
            return client;
        }
    }

    private UUID clientManagerId(Client client) {
        if (client == null) {
            return null;
        } else {
            Manager manager = client.getManager();
            if (manager == null) {
                return null;
            } else {
                UUID id = manager.getId();
                return id == null ? null : id;
            }
        }
    }
}

