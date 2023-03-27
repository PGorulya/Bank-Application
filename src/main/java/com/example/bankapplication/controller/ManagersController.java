package com.example.bankapplication.controller;

import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.dto.ManagerListDto;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.ManagerStatus;
import com.example.bankapplication.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ManagersController {

    private final ManagerService managerService;

    @GetMapping("/managers/{status}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDto getAllManagersByStatus(@PathVariable ManagerStatus status) {
        return managerService.findAllManagersByStatus(status);
    }

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public ManagerListDto getAllManagers() {

        return managerService.findAllManagers();
    }

}
