package com.example.bankapplication.service.util;

import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.Client;
import com.example.bankapplication.entity.Manager;
import com.example.bankapplication.entity.enums.*;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@UtilityClass
public class EntityCreator {
    public static final UUID UUID_EXAMPLE = UUID.fromString("788e611c-de42-4a94-a301-efac55bf159b");

    public static Account getAccountEntity() {
        return new Account(
                UUID_EXAMPLE,
                "Checking Account",
                AccountType.DEPOSIT,
                AccountStatus.ACTIVE,
                new BigDecimal("2500.00"),
                CurrencyCode.EUR,
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 15, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 15, 0, 0)),
                null,
                null,
                null,
                null
        );
    }

    public static Manager getManagerEntity() {
        return new Manager(
                UUID_EXAMPLE,
                "Andreas",
                "Seipel",
                ManagerStatus.ACTIVE,
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 10, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 10, 0, 0)),
                null,
                null //new HashSet<>()
        );
    }

    public static Client getClientEntity() {
        return new Client(
                UUID_EXAMPLE,
                ClientStatus.ACTIVE,
                "9812345",
                "Maik",
                "Arnd",
                "maik.arnd@google.com",
                "Kasseler str.19, Egalstadt Germany",
                "+49155729877",
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 10, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 10, 0, 0)),
                null,
                null
        );
    }

}
