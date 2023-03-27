package com.example.bankapplication.service.impl;


import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.dto.AccountListDto;
import com.example.bankapplication.entity.enums.AccountStatus;
import com.example.bankapplication.mapper.AccountMapper;
import com.example.bankapplication.repository.AccountRepository;
import com.example.bankapplication.service.exception.AccountNotFoundException;
import com.example.bankapplication.service.exception.ErrorMessage;
import com.example.bankapplication.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.AcceptPendingException;
import java.util.UUID;

import static com.example.bankapplication.service.exception.ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public AccountDto getAccountById(UUID id) {
        log.info("Get accounts with {}", id);
        return accountMapper.toDto(accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID)));
    }

    @Override
    public AccountListDto getAllAccountsActive() {
        log.info("Get all active accounts");
        return new AccountListDto(accountMapper.accountsToAccountsDto
                (accountRepository.getAllByStatus(AccountStatus.ACTIVE)));
    }
}
