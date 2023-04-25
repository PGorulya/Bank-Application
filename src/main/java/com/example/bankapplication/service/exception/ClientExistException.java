package com.example.bankapplication.service.exception;

public class ClientExistException extends RuntimeException{

    public ClientExistException(String message) {
        super(message);
    }
}
