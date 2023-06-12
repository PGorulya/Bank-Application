package com.example.bankapplication.service.util;

import com.example.bankapplication.dto.AccountDto;
import com.example.bankapplication.dto.ClientDto;
import com.example.bankapplication.dto.ManagerDto;
import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@UtilityClass
public class DtoCreator {
    public static AccountDto getAccountDto() {
        return new AccountDto(
                "788e611c-de42-4a94-a301-efac55bf159b",
                "Checking Account",
                "DEPOSIT",
                "ACTIVE",
                "2500.00",
                "EUR",
                "738a065c-e9fe-4095-93bb-fb8d7dcb212c",
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 15, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2023, 3, 13, 15, 0, 0))
        );
    }

    public static ManagerDto getManagerDto() {
        return new ManagerDto(
                "788e611c-de42-4a94-a301-efac55bf159b",
                "Andreas",
                "Seipel",
                "ACTIVE",
                Timestamp.valueOf(LocalDateTime.of(2023,3,13,10,0,0)),
                Timestamp.valueOf(LocalDateTime.of(2023,3,13,10,0,0))
        );
    }


    public static ClientDto getClientDto() {
        return new ClientDto(
                "738a065c-e9fe-4095-93bb-fb8d7dcb212c",
                "ACTIVE",
                "987456321",
                "Maik",
                "Arnd",
                "6c069e7-353e-4b93-8790-fd35e4b3eb44",
                "maik.arnd@google.com",
                "Kasseler Str.19, Egalstadt Germany",
                "+491557298777",
                Timestamp.valueOf(LocalDateTime.of(2023,3,13,10,0,0)),
                Timestamp.valueOf(LocalDateTime.of(2023,3,13,10,0,0))
        );
    }
}
