package com.example.demo.exceptions;

public class DuplicateItemsException extends RuntimeException {
    public DuplicateItemsException(String message) {
        super(message);
    }
}
