package com.example.bankapplication.service.util;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.enums.ManagerStatus;

import java.util.List;

public interface ManagerService {

    List<ManagerDto> findAllManagersByStatus(ManagerStatus status);

    List<ManagerDto> findAllManagers();

    ManagerDto addNewManager(ManagerDto managerDto);
}
