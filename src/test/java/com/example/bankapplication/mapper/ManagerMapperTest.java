package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.mapper.impl.ManagerMapperImplTest;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Manager Mapper test class")
class ManagerMapperTest {

    private final ManagerMapper managerMapper = new ManagerMapperImplTest();

    @Test
    void toDtoTest() {
        Manager manager = EntityCreator.getManagerEntity();
        ManagerDto managerDto = DtoCreator.getManagerDto();

        Assertions.assertEquals(managerDto, managerMapper.toDto(manager));
    }

    @Test
    void managersToManagersDtoTest() {
    }

    @Test
    void toManagerTest() {
        Manager manager = EntityCreator.getManagerEntity();
        ManagerDto managerDto = DtoCreator.getManagerDto();

        Assertions.assertEquals(manager, managerMapper.toManager(managerDto));
    }
}