package com.example.bankapplication.service.util;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;

import java.util.List;
import java.util.UUID;

public interface ManagerService {

    List<ManagerDto> findAllManagersByStatus(ManagerStatus status);

    List<ManagerDto> findAllManagers();

    ManagerDto addNewManager(ManagerDto managerDto);

    ManagerDto editManagerById(UUID id, ManagerDto managerDto);

    void deleteById(UUID id);
}
