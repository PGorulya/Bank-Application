package com.example.bankapplication.service.util;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.dto.AccountListDto;

import java.util.UUID;

public interface AccountService {

    AccountDto getAccountById(UUID id);

    AccountListDto getAllAccountsActive();
}
