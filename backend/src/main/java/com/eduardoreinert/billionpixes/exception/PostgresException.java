package com.eduardoreinert.billionpixes.exception;

public class PostgresException extends RuntimeException{

    public PostgresException(String message) {
        super(message);
    }
}
