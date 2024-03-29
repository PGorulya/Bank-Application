package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface AccountMapper {

    @Mapping(source = "account.client.id", target = "clientId")
    AccountDto toDto(Account account);

    List<AccountDto> accountsToAccountsDto(List<Account> accounts);

    Account toAccount(AccountDto accountDto);
}
