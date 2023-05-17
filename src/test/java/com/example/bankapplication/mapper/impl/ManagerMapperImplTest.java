package com.example.bankapplication.mapper.impl;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.mapper.ManagerMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@Component
public class ManagerMapperImplTest implements ManagerMapper {
    @Override
    public ManagerDto toDto(Manager manager) {
        if (manager == null) {
            return null;
        } else {
            String id = null;
            String firstName = null;
            String lastName = null;
            String status = null;
            Timestamp createdAt = null;
            Timestamp updatedAt = null;
            if (manager.getId() != null) {
                id = manager.getId().toString();
            }

            firstName = manager.getFirstName();
            lastName = manager.getLastName();
            if (manager.getStatus() != null) {
                status = manager.getStatus().name();
            }

            createdAt = manager.getCreatedAt();
            updatedAt = manager.getUpdatedAt();
            ManagerDto managerDto = new ManagerDto(id, firstName, lastName, status, createdAt, updatedAt);
            return managerDto;
        }
    }

    @Override
    public List<ManagerDto> managersToManagersDto(List<Manager> managers) {
        if (managers == null) {
            return null;
        } else {
            List<ManagerDto> list = new ArrayList(managers.size());
            Iterator var4 = managers.iterator();

            while(var4.hasNext()) {
                Manager manager = (Manager)var4.next();
                list.add(this.toDto(manager));
            }

            return list;
        }
    }

    @Override
    public Manager toManager(ManagerDto managerDto) {
        if (managerDto == null) {
            return null;
        } else {
            Manager manager = new Manager();
            manager.setCreatedAt(managerDto.getCreatedAt());
            manager.setFirstName(managerDto.getFirstName());
            if (managerDto.getId() != null) {
                manager.setId(UUID.fromString(managerDto.getId()));
            }

            manager.setLastName(managerDto.getLastName());
            if (managerDto.getStatus() != null) {
                manager.setStatus((ManagerStatus)Enum.valueOf(ManagerStatus.class, managerDto.getStatus()));
            }

            manager.setUpdatedAt(managerDto.getUpdatedAt());
            return manager;
        }
    }
}
