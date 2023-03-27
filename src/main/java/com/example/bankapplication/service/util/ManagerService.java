package com.example.bankapplication.service.util;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.dto.ManagerListDto;
import com.example.bankapplication.entity.enums.ManagerStatus;

public interface ManagerService {

    ManagerDto findAllManagersByStatus(ManagerStatus status);

    ManagerListDto findAllManagers();
}
