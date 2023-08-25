package com.reset.spring.rest.server.dao;


import com.reset.spring.rest.server.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
