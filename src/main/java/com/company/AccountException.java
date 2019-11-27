package com.company;

public class AccountException extends Exception {
    public String message;
    public AccountException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
