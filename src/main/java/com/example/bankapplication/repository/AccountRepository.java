package com.example.bankapplication.repository;

import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {


    List<Account> getAllByStatus(AccountStatus status);
}
