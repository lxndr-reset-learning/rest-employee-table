package com.reset.spring.rest.consumer.api_app_communication;

import com.reset.spring.rest.consumer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service //not @Component, because it's main business logic class
public class CommunicationService {
    private static final String URL = "http://localhost:8080/api/server/employees";

    private final RestTemplate restTemplate;

    @Autowired
    public CommunicationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        return this.exchange(HttpMethod.GET, URL, null, new ParameterizedTypeReference<List<Employee>>() {
        }).getBody();
    }

    public Employee getEmployee(int id) {
        return this.exchange(HttpMethod.GET, URL + "/%d".formatted(id), null, new ParameterizedTypeReference<Employee>() {
        }).getBody();
    }

    public void saveEmployee(Employee employee) {

        restTemplate.postForEntity(URL, employee, Void.class);
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/%d".formatted(id));
    }

    public String editEmployee(int id, Employee employee) {
        employee.setId(id);
        EmployeeValidator.validate(employee);
        restTemplate.put(URL, employee);

        return "Employee with id " + employee.getId() + " was edited successfully!";
    }

    private <T> ResponseEntity<T> exchange(HttpMethod method, String url, Object request, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(url, method, null, responseType);
    }
}