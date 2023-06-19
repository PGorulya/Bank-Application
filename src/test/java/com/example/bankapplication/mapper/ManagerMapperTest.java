package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.mapper.impl.ManagerMapperImplTest;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Manager Mapper test class")
class ManagerMapperTest {

    private final ManagerMapper managerMapper = new ManagerMapperImplTest();

    @Test
    @DisplayName("Positive test. Manager mapper to managerDto")
    void toDtoTest() {
        Manager manager = EntityCreator.getManagerEntity();
        ManagerDto managerDto = DtoCreator.getManagerDto();

        Assertions.assertEquals(managerDto, managerMapper.toDto(manager));
    }

    @Test
    @DisplayName("Positive test. Managers list mapper to list ManagerDto")
    void managersToManagersDtoTest() {
        Manager manager = EntityCreator.getManagerEntity();
        List<Manager> managerList = new ArrayList<>();
        managerList.add(manager);
        List<ManagerDto> ManagerDtoList = new ArrayList<>();
        ManagerDtoList.add(DtoCreator.getManagerDto());

        Assertions.assertEquals(ManagerDtoList, managerMapper.managersToManagersDto(managerList));
    }

    @Test
    @DisplayName("Positive test. ManagerDto mapper to manager")
    void toManagerTest() {
        Manager manager = EntityCreator.getManagerEntity();
        ManagerDto managerDto = DtoCreator.getManagerDto();

        Assertions.assertEquals(manager, managerMapper.toManager(managerDto));
    }
}