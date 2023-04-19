package com.example.bankapplication.controller;


import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.enums.AccountStatus;
import com.example.bankapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getAccountById(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/accounts/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccountsByStatus(@PathVariable AccountStatus status) {
        return accountService.getAllAccountsByStatus(status);
    }

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }


    @PostMapping(value = "/accounts/createAccount", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@Valid @RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @DeleteMapping("/accounts/deleteAccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountById(@PathVariable UUID id){
        accountService.deleteAccountById(id);
    }

}