package com.eduardoreinert.billionpixes.enums;

public enum LogMessagesEnum {
    ERROR_USER_CREATION("ERROR: user not created"),
    ERROR_USER_GET("ERROR: user returning"),

    SUCCESS_USER_CREATION("OK: user created"),
    SUCCESS_USER_GET("OK: user returned")
    ;

    private String message;

    LogMessagesEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
