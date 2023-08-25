package com.reset.spring.rest.consumer.exception;

public class WrongEmployeeDataException extends RuntimeException {
    public WrongEmployeeDataException(String message) {
        super(message);
    }

    public WrongEmployeeDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongEmployeeDataException(Throwable cause) {
        super(cause);
    }

    public WrongEmployeeDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
