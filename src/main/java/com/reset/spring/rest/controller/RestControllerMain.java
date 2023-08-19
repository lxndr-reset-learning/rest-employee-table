package com.reset.spring.rest.controller;


import com.reset.spring.rest.entity.Employee;
import com.reset.spring.rest.exception_handling.EmployeeIncorrectData;
import com.reset.spring.rest.exception_handling.exception.NoSuchEmployeeException;
import com.reset.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE) //useless, but a good practice
public class RestControllerMain {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable(value = "id") int id) throws Exception { // Reading data from url (in {}, not like "data=". For these we use @RequestParam))
        Employee employeeById = employeeService.getEmployeeById(id);

        if (employeeById != null) {
            return employeeById;
        }
        throw new NoSuchEmployeeException("Employee with id '" + id + "' does not exist!");
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> exceptionHandler(NoSuchElementException noSuchElementException) { // in generics we put type that should have about exception
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData(noSuchElementException.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }


}
