package com.test.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Employee does not exist"
)
public class EmployeeException extends RuntimeException{
    public EmployeeException(Throwable t){
        super(t);
    }

    public EmployeeException(String message){
        super(message);
    }
}
