package com.example.bankapplication.entity.enums;

public enum ManagerStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING"),
    REMOVED("REMOVED");
    private final String value;

    ManagerStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}