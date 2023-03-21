package com.example.bankapplication.entity.enums;

public enum AgreementStatus {
    ACTIVE(1),
    PENDING(2),
    REMOVED(3);
    private final int value;

    AgreementStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}