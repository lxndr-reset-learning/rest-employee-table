package com.reset.spring.rest.exception_handling.exception_data_store;

import lombok.Data;

@Data
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }
}
