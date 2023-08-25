package com.reset.spring.rest.consumer;

import com.reset.spring.rest.consumer.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        Communication communication = context.getBean("communication", Communication.class); // we can't use @Autowired because App is not a component
        List<Employee> allEmployees = communication.getAllEmployees();

        System.out.println(allEmployees);
    }
}
