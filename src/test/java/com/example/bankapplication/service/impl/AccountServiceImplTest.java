package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.enums.AccountStatus;
import com.example.bankapplication.mapper.AccountMapper;
import com.example.bankapplication.repository.AccountRepository;
import com.example.bankapplication.service.exception.AccountNotFoundException;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Account Service test class")
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @InjectMocks
    AccountServiceImpl service;
    @Mock
    AccountMapper accountMapper;
    @Mock
    AccountRepository accountRepository;

    private final AccountStatus status = AccountStatus.ACTIVE;
    Account account = EntityCreator.getAccountEntity();
    AccountDto accountDto = DtoCreator.getAccountDto();

    @Test
    @DisplayName("Positive Test. Get account by id")
    void getAccountByIdTest() {

        Mockito.when(accountRepository.findAccountById(account.getId())).thenReturn(Optional.of(account));
        Mockito.when(accountMapper.toDto(account)).thenReturn(accountDto);

        service.getAccountById(account.getId());

        Mockito.verify(accountRepository).findAccountById(account.getId());
        Mockito.verify(accountMapper).toDto(account);
    }

    @Test
    @DisplayName("Negative test. There is no element. Get account by Id.")
    void getNonExistAccountByIdTest() {
        UUID id = EntityCreator.UUID_EXAMPLE_CLIENT;
        assertThrows(AccountNotFoundException.class, () -> service.getAccountById(id));
    }

    @Test
    @DisplayName("Positive test. Get all accounts by status")
    void getAllAccountsByStatusTest() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(accountDto);

        Mockito.when(accountRepository.findAllByStatus(status)).thenReturn(Optional.of(accountList));
        Mockito.when(accountMapper.accountsToAccountsDto(accountList)).thenReturn(accountDtoList);

        service.getAllAccountsByStatus(status);

        Mockito.verify(accountRepository).findAllByStatus(status);
        Mockito.verify(accountMapper).accountsToAccountsDto(accountList);
    }

    @Test
    @DisplayName("Positive test. Get all accounts")
    void getAllAccountsTest() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(DtoCreator.getAccountDto());

        Mockito.when(accountRepository.findAll()).thenReturn(accountList);
        Mockito.when(accountMapper.accountsToAccountsDto(accountList)).thenReturn(accountDtoList);

        service.getAllAccounts();
        Mockito.verify(accountRepository).findAll();
        Mockito.verify(accountMapper).accountsToAccountsDto(accountList);
    }

    @Test
    void createAccountTest() {
    }

    @Test
    void deleteAccountByIdTest() {
    }
}