package com.reset.spring.rest.consumer;

import com.reset.spring.rest.consumer.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        Communication communication = context.getBean("communication", Communication.class); // we can't use @Autowired because App is not a component

        System.out.println(communication.getEmployee(1));
    }
}
