package com.example.bankapplication.service.impl;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.mapper.AccountMapper;
import com.example.bankapplication.repository.AccountRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

        Mockito.when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        Mockito.when(accountMapper.toDto(account)).thenReturn(accountDto);

        service.getAccountById(account.getId());

        Mockito.verify(accountRepository).findById(account.getId());
        Mockito.verify(accountMapper).toDto(account);



//        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
//        when(accountMapper.toDto(account)).thenReturn(accountDto);
//
//        AccountDto actualAccountDto = service.getAccountById(account.getId());
//
//        assertEquals(actualAccountDto, accountDto);

    }

    @Test
    void getNonExistAccountByIdTest() {
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