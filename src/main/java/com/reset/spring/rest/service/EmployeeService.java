package com.reset.spring.rest.service;


import com.reset.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
