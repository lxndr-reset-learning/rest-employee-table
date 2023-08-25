package com.reset.spring.rest.controller;


import com.reset.spring.rest.entity.Employee;
import com.reset.spring.rest.exception_handling.exception.NoSuchEmployeeException;
import com.reset.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Employee showEmployeeById(@PathVariable(value = "id") int id) { // Reading data from url (in {}, not like "data=". For these we use @RequestParam))
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id '" + id + "' does not exist!");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees") // id stores in request body
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public List<Employee> deleteEmployeeById(@PathVariable(value = "id") int id) {
        employeeService.deleteEmployeeById(id);
        return showAllEmployees();
    }
}
