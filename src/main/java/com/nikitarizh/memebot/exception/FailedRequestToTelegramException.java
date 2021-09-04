package com.nikitarizh.memebot.exception;

public class FailedRequestToTelegramException extends RuntimeException {
    public FailedRequestToTelegramException(Throwable cause) {
        super(cause);
    }
}
