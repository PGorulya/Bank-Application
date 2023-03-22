package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ManagerListDto;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.mapper.ManagerMapper;
import com.example.bankapplication.repository.ManagerRepository;
import com.example.bankapplication.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;


    public ManagerListDto getAllManagersStatus() {

        return new ManagerListDto(managerMapper.managersToManagersDto
                (managerRepository.getAllByStatus(ManagerStatus.ACTIVE)));
    }
}
