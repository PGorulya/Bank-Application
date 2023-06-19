package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
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

//    ClientRepository clientRepository;

    @Test
    @DisplayName("Positive Test. Get account by id")
    void getAccountByIdTest() {
        Account account = EntityCreator.getAccountEntity();
        AccountDto accountDto = DtoCreator.getAccountDto();

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
    void getAllAccountsByStatusTest() {
    }

    @Test
    void getAllAccountsTest() {
    }

    @Test
    void createAccountTest() {
    }

    @Test
    void deleteAccountByIdTest() {
    }
}