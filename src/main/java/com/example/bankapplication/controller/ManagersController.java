package com.example.bankapplication.controller;

import com.example.bankapplication.dto.ManagerListDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagersController {

    private final ManagerService managerService;

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public ManagerListDto getAllManagers() {

        return managerService.getAllManagersStatus();
    }

}
