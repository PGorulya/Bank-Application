package com.example.bankapplication.repository;

import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {

    List<Manager> getAllByStatus(ManagerStatus status);
}
