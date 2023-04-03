package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.mapper.ManagerMapper;
import com.example.bankapplication.repository.ManagerRepository;
import com.example.bankapplication.service.exception.ErrorMessage;
import com.example.bankapplication.service.exception.ManagerExistException;
import com.example.bankapplication.service.exception.ManagerNotFoundException;
import com.example.bankapplication.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;


    @Override
    @Transactional(readOnly = true)
    public List<ManagerDto> findAllManagersByStatus(ManagerStatus status) {
        log.info("Get managers with status {}", status);
        return managerMapper.managersToManagersDto(managerRepository.findAllByStatus(status).orElseThrow(
                () -> new ManagerNotFoundException
                        ((ErrorMessage.MANAGER_NOT_FOUND_BY_STATUS))));
    }

    public List<ManagerDto> findAllManagers() {
        log.info("Get all  managers");
        return managerMapper.managersToManagersDto(managerRepository.findAll());
    }

    @Override
    @Transactional
    public ManagerDto addNewManager(ManagerDto managerDto) {
        Manager manager = managerMapper.dtoToManager(managerDto);
        checkManagerExist(manager.getFirstName(), manager.getLastName());

        manager.setId(UUID.randomUUID());
        manager.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        manager.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        log.info("Add new manager {}", manager);

        managerRepository.save(manager);
        return managerMapper.toDto(manager);
    }

    public void checkManagerExist(String firstName, String lastName){
        Manager exustManager = managerRepository.findByFirstNameAndLastName(firstName, lastName);
        if (exustManager != null)
            throw new ManagerExistException("The manager with the same firstName and lastName already exists");
    }
}
