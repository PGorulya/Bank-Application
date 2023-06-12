package com.example.bankapplication.service.impl;


import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.enums.AccountStatus;
import com.example.bankapplication.mapper.AccountMapper;
import com.example.bankapplication.repository.AccountRepository;
import com.example.bankapplication.repository.ClientRepository;
import com.example.bankapplication.service.AccountService;
import com.example.bankapplication.service.exception.AccountNotFoundException;
import com.example.bankapplication.service.exception.ClientNotFoundException;
import com.example.bankapplication.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public AccountDto getAccountById(UUID id) {
        log.info("Get accounts with id = {}", id);
        return accountMapper.toDto(accountRepository.findAccountById(id).
                orElseThrow(
                        () -> new AccountNotFoundException
                                (ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountDto> getAllAccountsByStatus(AccountStatus status) {
        log.info("Get all accounts with status {}", status);
        return accountMapper.accountsToAccountsDto
                (accountRepository.findAllByStatus(status).
                orElseThrow(
                        () -> new AccountNotFoundException
                                ((ErrorMessage.ACCOUNT_NOT_FOUND_BY_STATUS))));
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        log.info("Get all accounts");
        return accountMapper.accountsToAccountsDto
                (accountRepository.findAll());
    }

    @Override
    @Transactional
    public AccountDto createAccount(AccountDto accountDto) {
        log.info("Create the new Account");
        if(accountDto.getClientId() == null)
            throw new IllegalArgumentException("clientId is null");
        var idClient = accountDto.getClientId();
        clientRepository.findClientById(UUID.fromString(idClient)).
                orElseThrow(
                    ()-> new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND));

        Account account = accountMapper.toAccount(accountDto);

        account.setId(UUID.randomUUID());
        account.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        account.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        log.info("Created new account {}", account);
        accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    @Override
    @Transactional
    public void deleteAccountById(UUID id) {
        log.info("Deleting account {}", id);
        var account = accountRepository.findAccountById(id);
        if(account.isPresent())
            accountRepository.deleteById(id);
        else throw new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID);
    }
}
