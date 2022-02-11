package com.example.eschool_greetgo.exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String could_not_find) {
        super(could_not_find);
    }
}
