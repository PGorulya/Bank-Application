package com.example.bankapplication.repository;

import com.example.bankapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
//    Optional<List<Client>> findAllByStatus(ClientStatus status);

    List<Client> findAllClients();

    Client findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Client> findClientById(UUID id);


}
