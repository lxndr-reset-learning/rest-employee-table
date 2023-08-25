package com.reset.spring.rest.controller;


import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.reset.spring.rest.entity.Employee;
import com.reset.spring.rest.exception_handling.exception.NoSuchEmployeeException;
import com.reset.spring.rest.exception_handling.exception_data_store.EmployeeIncorrectData;
import com.reset.spring.rest.exception_handling.exception_data_store.EmployeeTypeMismatch;
import com.reset.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

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
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id '" + id + "' does not exist!");
        }

        return employee;
    }




}
