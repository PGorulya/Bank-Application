package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface ManagerMapper {

    ManagerDto toDto(Manager manager);

    List<ManagerDto> managersToManagersDto(List<Manager> managers);

    Manager toManager(ManagerDto managerDto);

}
