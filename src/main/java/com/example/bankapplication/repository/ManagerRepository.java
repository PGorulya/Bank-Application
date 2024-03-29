package com.example.bankapplication.repository;

import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {

    Optional<List<Manager>> findAllByStatus(ManagerStatus status);

    List<Manager> findAll();


    Manager findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Manager> findManagerById(UUID id);

}
