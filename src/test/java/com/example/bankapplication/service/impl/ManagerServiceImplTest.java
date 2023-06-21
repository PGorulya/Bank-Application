package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.mapper.ManagerMapper;
import com.example.bankapplication.repository.ManagerRepository;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DisplayName("Manager Service test class")
@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {
    @InjectMocks
    ManagerServiceImpl service;
    @Mock
    ManagerMapper managerMapper;
    @Mock
    ManagerRepository managerRepository;

    private final ManagerStatus status = ManagerStatus.ACTIVE;
    Manager manager = EntityCreator.getManagerEntity();
    ManagerDto managerDto = DtoCreator.getManagerDto();

    @Test
    @DisplayName("Positive test. Get all clients by status")
    void getAllManagersByStatusTest() {
        List<Manager> managerList = new ArrayList<>();
        managerList.add(manager);
        List<ManagerDto> managerDtoList = new ArrayList<>();
        managerDtoList.add(managerDto);

        Mockito.when(managerRepository.findAllByStatus(status)).thenReturn(Optional.of(managerList));
        Mockito.when(managerMapper.managersToManagersDto(managerList)).thenReturn(managerDtoList);

        service.getAllManagersByStatus(status);

        Mockito.verify(managerRepository).findAllByStatus(status);
        Mockito.verify(managerMapper).managersToManagersDto(managerList);
    }

    @Test
    @DisplayName("Positive test. Get all managers")
    void getAllManagersTest() {
        List<Manager> managerList = new ArrayList<>();
        managerList.add(manager);
        List<ManagerDto> managerDtoList = new ArrayList<>();
        managerDtoList.add(managerDto);

        Mockito.when(managerRepository.findAll()).thenReturn(managerList);
        Mockito.when(managerMapper.managersToManagersDto(managerList)).thenReturn(managerDtoList);

        service.getAllManagers();

        Mockito.verify(managerRepository).findAll();
        Mockito.verify(managerMapper).managersToManagersDto(managerList);
    }

    @Test
    void addNewManagerTest() {
    }

    @Test
    void editManagerByIdTest() {
    }

    @Test
    void deleteManagerByIdTest() {
    }
}