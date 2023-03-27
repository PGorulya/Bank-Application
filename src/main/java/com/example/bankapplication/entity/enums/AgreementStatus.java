package com.example.bankapplication.entity.enums;

public enum AgreementStatus {
    ACTIVE(0),
    PENDING(1),
    REMOVED(2);
    private final int value;

    AgreementStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}