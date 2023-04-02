package com.example.bankapplication.controller;


import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto getInfoAboutAccount(@PathVariable UUID id) {

        return accountService.getAccountById(id);
    }

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> getAllAccounts() {

        return accountService.getAllAccountsActive();
    }
}