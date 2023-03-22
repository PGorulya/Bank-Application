package com.example.bankapplication.dto;

import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@Value
public class ManagerDto {
    String id;

    String firstName;

    String lastName;

    String status;

//    String createdAt;

//    String updatedAt;
}

