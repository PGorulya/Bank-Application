package com.example.bankapplication.service;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.enums.AccountStatus;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto getAccountById(UUID id);

    List<AccountDto> getAllAccountsByStatus(AccountStatus status);

    List<AccountDto> getAllAccounts();

    AccountDto createAccount(AccountDto accountDto);

    void deleteAccountById(UUID id);

}
