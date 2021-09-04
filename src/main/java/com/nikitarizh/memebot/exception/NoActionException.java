package com.nikitarizh.memebot.exception;

public class NoActionException extends RuntimeException {
    public NoActionException(String command) {
        super("No action is defined for command " + command);
    }
}
