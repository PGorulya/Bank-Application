package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.mapper.ManagerMapper;
import com.example.bankapplication.repository.ManagerRepository;
import com.example.bankapplication.service.exception.ErrorMessage;
import com.example.bankapplication.service.exception.ManagerExistException;
import com.example.bankapplication.service.exception.ManagerNotFoundException;
import com.example.bankapplication.service.ManagerService;
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
    public List<ManagerDto> getAllManagersByStatus(ManagerStatus status) {
        log.info("Get managers with status {}", status);
        return managerMapper.managersToManagersDto
                (managerRepository.findAllByStatus(status).
                orElseThrow(
                        () -> new ManagerNotFoundException
                            ((ErrorMessage.MANAGER_NOT_FOUND_BY_STATUS))));
    }

    @Override
    public List<ManagerDto> getAllManagers() {
        log.info("Get all  managers");
        return managerMapper.managersToManagersDto(managerRepository.findAll());
    }

    @Override
    @Transactional
    public ManagerDto addNewManager(ManagerDto managerDto) {
        log.info("Addition the new Manager");
        Manager manager = managerMapper.toManager(managerDto);
        checkManagerExist(manager.getFirstName(), manager.getLastName());

        manager.setId(UUID.randomUUID());
        manager.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        manager.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        log.info("Added new manager {}", manager);

        managerRepository.save(manager);
        return managerMapper.toDto(manager);
    }


    private void checkManagerExist(String firstName, String lastName){
        Manager existManager = managerRepository.findByFirstNameAndLastName(firstName, lastName);
        if (existManager != null)
            throw new ManagerExistException("The manager with the same firstName and lastName already exists");
    }

    @Override
    @Transactional
    public ManagerDto editManagerById(UUID id, ManagerDto managerDto) {
        var manager = managerRepository.findManagerById(id).orElseThrow(
                () -> new ManagerNotFoundException(ErrorMessage.MANAGER_NOT_FOUND_BY_ID)
        );

        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        manager.setStatus(ManagerStatus.valueOf(managerDto.getStatus()));
        manager.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        log.info("Edit manager {}", manager);

        var result = managerRepository.save(manager);
        return managerMapper.toDto(result);
    }

    @Override
    @Transactional
    public void deleteManagerById(UUID id) {
        log.info("Deleting manager {}", id);
        managerRepository.deleteById(id);
    }
}
