package org.example.mvc_demo.exception;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException() {
    }
    public NoSuchUserException(String message) {
        super(message);
    }
}
