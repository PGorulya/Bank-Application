package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
import com.example.bankapplication.mapper.impl.AccountMapperImplTest;
import com.example.bankapplication.service.util.DtoCreator;
import com.example.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Account Mapper test class")
class AccountMapperTest {

    private final AccountMapper accountMapper = new AccountMapperImplTest();

    @Test
    void toDtoTest() {
        Account account = EntityCreator.getAccountEntity();
        AccountDto accountDto = DtoCreator.getAccountDto();

        Assertions.assertEquals(accountDto, accountMapper.toDto(account));
    }

    @Test
    @DisplayName("Positive test. Accounts list mapper to list AccountDto")
    void accountsToAccountsDtoTest() {
        Account account = EntityCreator.getAccountEntity();
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<AccountDto> AccountDtoList = new ArrayList<>();
        AccountDtoList.add(DtoCreator.getAccountDto());

        Assertions.assertEquals(AccountDtoList, accountMapper.accountsToAccountsDto(accountList));
    }

    @Test
    void toAccountTest() {
        Account account = EntityCreator.getAccountEntity();
        AccountDto accountDto = DtoCreator.getAccountDto();

        Assertions.assertEquals(account, accountMapper.toAccount(accountDto));
    }
}