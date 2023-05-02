package com.example.bankapplication.controller;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/managers/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getAllManagersByStatus(@PathVariable ManagerStatus status) {
        return managerService.getAllManagersByStatus(status);
    }

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getAllManagers() {
        return managerService.getAllManagers();
    }

    @PostMapping(value = "/managers/newManager", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDto addNewManager(@RequestBody ManagerDto managerDto) {
        return managerService.addNewManager(managerDto);
    }

    @PutMapping(path = "/managers/edit/{id}", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDto editManagerById(@PathVariable UUID id, @RequestBody ManagerDto managerDto) {
        return managerService.editManagerById(id, managerDto);
    }

    @DeleteMapping("/managers/deleteManager/{id}")
    public void deleteManagerById(@PathVariable UUID id) {
        managerService.deleteManagerById(id);
    }

}
