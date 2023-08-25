package com.reset.spring.rest.consumer.entity;


import lombok.Data;

//we don't bind this entity to database, so we don't need all these annotations that persist in Sever part
@Data
public class Employee {
    private int id;

    private String name;

    private String surname;

    private String department;

    private int salary;

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {
    }
}
