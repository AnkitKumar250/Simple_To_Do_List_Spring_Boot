package com.app.todoapp.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class TaskException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public TaskException(String message, Throwable throwabe, HttpStatus httpStatus){
        this.message = message;
        this.throwable = throwabe;
        this.httpStatus = httpStatus;
    }
}
