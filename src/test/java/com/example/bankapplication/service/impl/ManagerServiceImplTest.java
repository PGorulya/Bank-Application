package com.example.bankapplication.service.impl;

import com.example.bankapplication.mapper.ManagerMapper;
import com.example.bankapplication.repository.ManagerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Manager Service test class")
@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {
    @InjectMocks
    ManagerServiceImpl service;
    @Mock
    ManagerMapper managerMapper;
    @Mock
    ManagerRepository managerRepository;
    @Test
    void getAllManagersByStatusTest() {
    }

    @Test
    void getAllManagersTest() {
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