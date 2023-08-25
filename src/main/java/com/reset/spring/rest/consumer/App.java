package com.reset.spring.rest.consumer;

import com.reset.spring.rest.consumer.api_app_communication.CommunicationService;
import com.reset.spring.rest.consumer.api_app_communication.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        CommunicationService communication = context.getBean("communicationService", CommunicationService.class); // we can't use @Autowired because App is not a component

        // feel free to use API :D
    }
}
