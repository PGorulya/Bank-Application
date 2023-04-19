package com.example.bankapplication.service;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.enums.ManagerStatus;

import java.util.List;
import java.util.UUID;

public interface ManagerService {

    List<ManagerDto> getAllManagersByStatus(ManagerStatus status);

    List<ManagerDto> getAllManagers();

    ManagerDto addNewManager(ManagerDto managerDto);

    ManagerDto editManagerById(UUID id, ManagerDto managerDto);

    void deleteManagerById(UUID id);
}
