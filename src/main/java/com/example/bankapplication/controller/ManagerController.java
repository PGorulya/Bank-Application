package com.example.bankapplication.controller;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/managers/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getAllManagersByStatus(@PathVariable ManagerStatus status) {
        return managerService.findAllManagersByStatus(status);
    }

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getAllManagers() {
        return managerService.findAllManagers();
    }

    @PostMapping(value = "/managers/newManager", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDto addNewManager(@Valid @RequestBody ManagerDto managerDto) {
        return managerService.addNewManager(managerDto);
    }
}
