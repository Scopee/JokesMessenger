package ru.pinguin.jokesmessenger.exceptions;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
