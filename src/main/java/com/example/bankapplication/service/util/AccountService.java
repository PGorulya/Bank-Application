package com.example.bankapplication.service.util;

import com.example.bankapplication.dto.AccountDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto getAccountById(UUID id);

    List<AccountDto> getAllAccountsActive();
}
