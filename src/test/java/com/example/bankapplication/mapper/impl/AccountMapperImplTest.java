package com.example.bankapplication.mapper.impl;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.entity.enums.AccountStatus;
import com.example.bankapplication.entity.enums.AccountType;
import com.example.bankapplication.entity.enums.CurrencyCode;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.example.bankapplication.mapper.AccountMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImplTest implements AccountMapper {

    @Override
    public AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        } else {
            String clientId = null;
            String id = null;
            String name = null;
            String type = null;
            String status = null;
            String balance = null;
            String currencyCode = null;
            Timestamp createdAt = null;
            Timestamp updatedAt = null;
            UUID id1 = this.accountClientId(account);
            if (id1 != null) {
                clientId = id1.toString();
            }

            if (account.getId() != null) {
                id = account.getId().toString();
            }

            name = account.getName();
            if (account.getType() != null) {
                type = account.getType().name();
            }

            if (account.getStatus() != null) {
                status = account.getStatus().name();
            }

            if (account.getBalance() != null) {
                balance = account.getBalance().toString();
            }

            if (account.getCurrencyCode() != null) {
                currencyCode = account.getCurrencyCode().name();
            }

            createdAt = account.getCreatedAt();
            updatedAt = account.getUpdatedAt();
            AccountDto accountDto = new AccountDto(id, name, type, status, balance, currencyCode, clientId, createdAt, updatedAt);
            return accountDto;
        }
    }

    @Override
    public List<AccountDto> accountsToAccountsDto(List<Account> accounts) {
        if (accounts == null) {
            return null;
        } else {
            List<AccountDto> list = new ArrayList(accounts.size());
            Iterator var3 = accounts.iterator();

            while(var3.hasNext()) {
                Account account = (Account)var3.next();
                list.add(this.toDto(account));
            }

            return list;
        }
    }

    @Override
    public Account toAccount(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        } else {
            Account account = new Account();
            if (accountDto.getId() != null) {
                account.setId(UUID.fromString(accountDto.getId()));
            }

            account.setName(accountDto.getName());
            if (accountDto.getType() != null) {
                account.setType((AccountType)Enum.valueOf(AccountType.class, accountDto.getType()));
            }

            if (accountDto.getStatus() != null) {
                account.setStatus((AccountStatus)Enum.valueOf(AccountStatus.class, accountDto.getStatus()));
            }

            if (accountDto.getBalance() != null) {
                account.setBalance(new BigDecimal(accountDto.getBalance()));
            }

            if (accountDto.getCurrencyCode() != null) {
                account.setCurrencyCode((CurrencyCode)Enum.valueOf(CurrencyCode.class, accountDto.getCurrencyCode()));
            }

            account.setCreatedAt(accountDto.getCreatedAt());
            account.setUpdatedAt(accountDto.getUpdatedAt());
            return account;
        }
    }

    private UUID accountClientId(Account account) {
        if (account == null) {
            return null;
        } else {
            Client client = account.getClient();
            if (client == null) {
                return null;
            } else {
                UUID id = client.getId();
                return id == null ? null : id;
            }
        }
    }
}
