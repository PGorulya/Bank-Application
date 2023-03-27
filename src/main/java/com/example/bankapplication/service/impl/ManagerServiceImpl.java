package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.dto.ManagerListDto;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.mapper.ManagerMapper;
import com.example.bankapplication.repository.ManagerRepository;
import com.example.bankapplication.service.exception.ErrorMessage;
import com.example.bankapplication.service.exception.ManagerNotFoundException;
import com.example.bankapplication.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

    @Override
    @Transactional(readOnly = true)
    public ManagerDto findAllManagersByStatus(ManagerStatus status) {
        log.info("Get managers with status {}", status);
        return managerMapper.toDto(managerRepository.findAllByStatus(status).orElseThrow(
                () -> new ManagerNotFoundException
                        ((ErrorMessage.MANAGER_NOT_FOUND_BY_STATUS))));
    }

    public ManagerListDto findAllManagers() {
        log.info("Get all  managers");
        return new ManagerListDto(managerMapper.managersToManagersDto
                (managerRepository.findAll()));
    }
}
