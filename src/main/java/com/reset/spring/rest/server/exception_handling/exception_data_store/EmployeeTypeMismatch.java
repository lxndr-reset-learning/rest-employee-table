package com.reset.spring.rest.server.exception_handling.exception_data_store;

import lombok.Data;

@Data
public class EmployeeTypeMismatch {
    private String info;

    public EmployeeTypeMismatch(String info) {
        this.info = info;
    }
}
