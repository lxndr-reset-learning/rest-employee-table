package com.reset.spring.rest.server.exception_handling;

import com.reset.spring.rest.server.exception_handling.exception.NoSuchEmployeeException;
import com.reset.spring.rest.server.exception_handling.exception_data_store.EmployeeIncorrectData;
import com.reset.spring.rest.server.exception_handling.exception_data_store.EmployeeTypeMismatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice //despite the name, mainly used as global exception handler annotation
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> exceptionHandler(NoSuchEmployeeException noSuchEmployeeException) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData(noSuchEmployeeException.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeTypeMismatch> exceptionHandler(MethodArgumentTypeMismatchException mismatchException) {
        EmployeeTypeMismatch mismatch = new EmployeeTypeMismatch(mismatchException.getMessage());

        return new ResponseEntity<>(mismatch, HttpStatus.BAD_REQUEST);
    }
}
