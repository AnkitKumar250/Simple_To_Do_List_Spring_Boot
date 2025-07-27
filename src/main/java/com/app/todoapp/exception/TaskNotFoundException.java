package com.app.todoapp.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message){
        super(message);
    }

    public TaskNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
