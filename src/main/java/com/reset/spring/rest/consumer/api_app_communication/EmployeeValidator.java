package com.reset.spring.rest.consumer.api_app_communication;

import com.reset.spring.rest.consumer.entity.Employee;
import com.reset.spring.rest.consumer.exception.WrongEmployeeDataException;

public class EmployeeValidator implements DataValidator {
    public static void validate(Employee employee) {
        validateNumber(employee.getId(), "ID");
        validateString(employee.getDepartment(), "Department");
        validateNumber(employee.getSalary(), "Salary");
        validateString(employee.getSurname(), "Surname");
        validateString(employee.getName(), "Name");
    }

    private static void validateString(String data, String fieldName) {
        validateNotNull(data, fieldName);
        if (data.length() <= 1) {
            throw new WrongEmployeeDataException(fieldName + " should be at least 2 symbols");
        }
    }

    private static void validateNumber(Integer data, String fieldName) {
        validateNotNull(data, fieldName);
        if (data < 0) {
            throw new WrongEmployeeDataException(fieldName + " should be more or equals than 0");
        }
    }

    private static void validateNotNull(Object object, String fieldName) {
        if (object == null) {
            throw new WrongEmployeeDataException(fieldName + " input data can't be null");
        }
    }
}